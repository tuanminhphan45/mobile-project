package vn.edu.usth.mobile_project;

import android.graphics.Outline;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);

        // apply layout to fragments
        ToolbarFragment toolbarFragment = (ToolbarFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_toolbar);

        // set the toolbar as the app bar for the activity (since the original theme is NoActionBar)
        Toolbar toolbar = null;
        if(toolbarFragment != null && toolbarFragment.getView() != null){
            toolbar = toolbarFragment.getView().findViewById(R.id.toolbar);
            if(toolbar!= null){
                setSupportActionBar(toolbar);

                // create the toolbar shadow
                ToolbarOutlineProvider outlineProvider = new ToolbarOutlineProvider();
                toolbar.setOutlineProvider(outlineProvider);
                toolbar.setClipToOutline(false);
                toolbar.setElevation(4);
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

