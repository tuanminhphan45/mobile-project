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
                holder.toggleOverlay();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.emails.size();
    }

    public interface OnItemClickListener {
        void onItemClick();
    }

}
