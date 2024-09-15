package vn.edu.usth.mobile_project.Fragment;

import android.content.Intent;
import android.graphics.ImageDecoder;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.widget.LinearLayout;

import java.util.ArrayList;

import vn.edu.usth.mobile_project.Activity.LoginActivity;
import vn.edu.usth.mobile_project.Activity.MainActivity;
import vn.edu.usth.mobile_project.Activity.SearchActivity;
import vn.edu.usth.mobile_project.Activity.WriteActivity;
import vn.edu.usth.mobile_project.Adapter.MailAdapter;
import vn.edu.usth.mobile_project.Model.EmailItem;
import vn.edu.usth.mobile_project.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InboxFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InboxFragment extends Fragment {
    RecyclerView recyclerView;
    MailAdapter mailAdapter;

    ArrayList<EmailItem> emails;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private MainActivity mainActivity;

    public InboxFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InboxFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InboxFragment newInstance(String param1, String param2) {
        InboxFragment fragment = new InboxFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inbox, container, false);

        // create the list of email items
        emails = new ArrayList<>();
        createEmailList();
        Log.d("myTag", emails.toString());
        recyclerView = view.findViewById(R.id.recyclerMails);
        mailAdapter = new MailAdapter(getActivity(), emails);
        recyclerView.setAdapter(mailAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // setup floating button
        FloatingActionButton floatingActionButton = view.findViewById(R.id.write_email);
        mainActivity= (MainActivity)getActivity();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity, WriteActivity.class);
                startActivity(intent);
            }
        });
        return view;

    }

    private void createEmailList(){
        for(int i = 0; i < 20; i++){
            emails.add(new EmailItem("Jenny Boyer", "Helena", 40, getString(R.string.email_content)));
        }
    }

    private void openMail(){
        // Replace the whole screen with the new fragment
        Fragment emailDetailFragment = new MailFragment();

        // Perform the fragment transaction
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainContainer, emailDetailFragment);
        transaction.addToBackStack(null); // Add to back stack to allow "back" navigation
        transaction.commit();
    }
}