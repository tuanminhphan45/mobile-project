package vn.edu.usth.mobile_project.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import vn.edu.usth.mobile_project.Activity.MainActivity;
import vn.edu.usth.mobile_project.Activity.WriteActivity;
import vn.edu.usth.mobile_project.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StatterdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StatterdFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StatterdFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StatterdFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StatterdFragment newInstance(String param1, String param2) {
        StatterdFragment fragment = new StatterdFragment();
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
        View view   = inflater.inflate(R.layout.fragment_inbox, container, false);
        FloatingActionButton floatingActionButton = view.findViewById(R.id.write_email);
        MainActivity mainActivity = (MainActivity) getActivity();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WriteActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}