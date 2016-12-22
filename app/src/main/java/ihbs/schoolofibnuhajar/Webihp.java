package ihbs.schoolofibnuhajar;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.android.gms.tagmanager.Container;

/**
 * Created by RedCamel on 11/15/15.
 */
public class Webihp extends Fragment {
    WebView webViewihp;
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle Saved){
        View v = inflater.inflate(R.layout.webihp,null); getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        webViewihp = (WebView)v.findViewById(R.id.webViewihp);
        progressBar = (ProgressBar)v.findViewById(R.id.progressBarihp);
        webViewihp.getSettings().setJavaScriptEnabled(true);
        webViewihp.setWebViewClient(new WebViewClient());
        webViewihp.getSettings().setDomStorageEnabled(true);
        webViewihp.getSettings().setLoadWithOverviewMode(true);
        webViewihp.getSettings().setUseWideViewPort(true);
        webViewihp.getSettings().setSupportMultipleWindows(true);
        webViewihp.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webViewihp.setHorizontalScrollBarEnabled(false);
        webViewihp.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webViewihp.getSettings().setAllowFileAccessFromFileURLs(true);
        webViewihp.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webViewihp.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(progress);
                if (progress == 100) {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
        progressBar.setVisibility(View.VISIBLE);
        webViewihp.loadUrl("http://ibnuhajarpersada.com/");
        return v;


    }

}
