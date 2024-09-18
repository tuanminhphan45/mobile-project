package vn.edu.usth.mobile_project.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import vn.edu.usth.mobile_project.Activity.MainActivity;
import vn.edu.usth.mobile_project.Activity.ReadMailActivity;
import vn.edu.usth.mobile_project.Model.EmailItem;
import vn.edu.usth.mobile_project.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MailAdapter extends RecyclerView.Adapter<mailVH> {
    private Context context;
    private ArrayList<EmailItem> emails;

    public MailAdapter(Context context, ArrayList<EmailItem> emails){
        this.context = context;
        this.emails = emails;
    }

    @NonNull
    @Override
    public mailVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View email = inflater.inflate(R.layout.item_love, parent, false);
        mailVH mailVh = new mailVH(email);
        return mailVh;
    }

    @Override
    public void onBindViewHolder(@NonNull mailVH holder, int position) {
        // bind email item data to the ViewHolder
        EmailItem emailItem = this.emails.get(position);
        holder.setProfileImg(R.drawable.profile_picture); /**@TODO: change with dynamic image source later*/
        holder.setUsername(emailItem.getUsername());
        holder.setSubject(emailItem.getSubject());
        holder.setTimeSent(emailItem.getTimeSent());
        holder.setContent(emailItem.getContent());
        if (emailItem.isStarred()){
            holder.setStar(true);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("item", "open mail");
                Intent intent = new Intent(context, ReadMailActivity.class);
                context.startActivity(intent);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showBottomDialog();
                holder.toggleOverlay();
                return true;
            }
        });

    }
    private void showBottomDialog() {
        // Use the context from the adapter
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }


    @Override
    public int getItemCount() {
        return this.emails.size();
    }

    public interface OnItemClickListener {
        void onItemClick();
    }

}
