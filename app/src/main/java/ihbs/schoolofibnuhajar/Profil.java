package ihbs.schoolofibnuhajar;

import android.app.Activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by RedCamel on 11/11/15.
 */
public class Profil extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle Saved){
        View v = inflater.inflate(R.layout.profil,null); getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        return v;
    }
}
