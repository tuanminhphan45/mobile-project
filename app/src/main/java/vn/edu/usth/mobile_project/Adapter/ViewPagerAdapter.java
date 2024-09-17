package vn.edu.usth.mobile_project.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.edu.usth.mobile_project.Fragment.FloderFragment;
import vn.edu.usth.mobile_project.Fragment.InboxFragment;
import vn.edu.usth.mobile_project.Fragment.StatterdFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new FloderFragment();
            case 1: return  new InboxFragment();
            case 2: return  new StatterdFragment();
            default: return new FloderFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
