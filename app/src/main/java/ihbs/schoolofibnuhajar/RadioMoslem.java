package ihbs.schoolofibnuhajar;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by RedCamel on 11/15/15.
 */
public class RadioMoslem extends Fragment {
    Button btnsohib;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle Saved){
        View v = inflater.inflate(R.layout.radiomoslem,null); getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnsohib = (Button)v.findViewById(R.id.btnsohibradio);
        btnsohib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == btnsohib) {
                    Intent a1 = new Intent(getActivity(), RadioSohib.class);
                    startActivity(a1);
                }

            }

        });


        return v;
    }
}
