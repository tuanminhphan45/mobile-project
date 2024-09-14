package vn.edu.usth.mobile_project.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import vn.edu.usth.mobile_project.R;

public class VH extends RecyclerView.ViewHolder {
    private ImageView profileImg;
    private TextView username;
    private TextView subject;
    private TextView timeSent;
    private TextView content;
    public VH(@NonNull View itemView) {
        super(itemView);

        this.profileImg = itemView.findViewById(R.id.profile_image);
        this.username = itemView.findViewById(R.id.user_name);
        this.subject = itemView.findViewById(R.id.subject);
        this.timeSent = itemView.findViewById(R.id.time_sent);
        this.content = itemView.findViewById(R.id.content);
    }

    public void setProfileImg(int imgId) {
        this.profileImg.setImageResource(imgId);
    }

    public void setUsername(String username) {
        this.username.setText(username);
    }

    public void setSubject(String subject) {
        this.subject.setText(subject);
    }

    public void setTimeSent(int timeSent) {
        this.timeSent.setText("" + timeSent);
    }

    public void setContent(String content) {
        this.content.setText(content);
    }
}
