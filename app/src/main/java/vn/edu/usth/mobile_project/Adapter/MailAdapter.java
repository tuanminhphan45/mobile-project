package vn.edu.usth.mobile_project.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import vn.edu.usth.mobile_project.Model.EmailItem;
import vn.edu.usth.mobile_project.R;

public class MailAdapter extends RecyclerView.Adapter<VH> {
    private Context context;
    private ArrayList<EmailItem> emails;

    public MailAdapter(Context context, ArrayList<EmailItem> emails){
        this.context = context;
        this.emails = emails;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View email = inflater.inflate(R.layout.item_inbox, parent, false);
        VH vh = new VH(email);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        // display the data at the specified position
        EmailItem emailItem = this.emails.get(position);
        holder.setProfileImg(R.drawable.profile_picture); /**@TODO: change with dynamic image source later*/
        holder.setUsername(emailItem.getUsername());
        holder.setMainName(emailItem.getMainName());
        holder.setTimeSent(emailItem.getTimeSent());
        holder.setContent(emailItem.getContent());
    }

    @Override
    public int getItemCount() {
        return this.emails.size();
    }
}
