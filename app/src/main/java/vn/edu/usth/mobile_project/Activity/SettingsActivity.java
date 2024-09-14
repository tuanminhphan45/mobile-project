package vn.edu.usth.mobile_project.Activity;

import android.content.Intent;
import android.graphics.Outline;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import vn.edu.usth.mobile_project.Fragment.ToolbarFragment;
import vn.edu.usth.mobile_project.R;

public class SettingsActivity extends AppCompatActivity {
    ToolbarFragment toolbarFragment;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);

        // apply layout to fragments
        toolbarFragment = (ToolbarFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_toolbar);

        if(toolbarFragment != null && toolbarFragment.getView() != null){
            toolbar = toolbarFragment.getView().findViewById(R.id.toolbar);
            if(toolbar!= null){
                // set the toolbar as the app bar for the activity (since the original theme is NoActionBar)
                setSupportActionBar(toolbar);
            }
        }else {
            System.out.println("Null Toolbar");
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.appSettings), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}

