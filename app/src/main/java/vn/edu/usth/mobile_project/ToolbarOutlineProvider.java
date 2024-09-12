package vn.edu.usth.mobile_project;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

public class ToolbarOutlineProvider extends ViewOutlineProvider {
    public ToolbarOutlineProvider(){
        super();
    }

    @Override
    public void getOutline(View view, Outline outline){
        outline.setRect(0, 0, view.getWidth(), view.getHeight());
    }
}
