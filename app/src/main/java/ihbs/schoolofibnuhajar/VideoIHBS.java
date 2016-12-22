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

/**
 * Created by RedCamel on 11/11/15.
 */
public class VideoIHBS extends Fragment {
    WebView webViewVideo;
    ProgressBar progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle Saved){
        View v = inflater.inflate(R.layout.video_ihbs,null); getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        webViewVideo = (WebView)v.findViewById(R.id.webviewvideoihbs);
        progressBar = (ProgressBar)v.findViewById(R.id.progressbarvideoihbs);
        webViewVideo.getSettings().setJavaScriptEnabled(true);
        webViewVideo.setWebViewClient(new WebViewClient());
        webViewVideo.getSettings().setDomStorageEnabled(true);
        webViewVideo.getSettings().setLoadWithOverviewMode(true);
        webViewVideo.getSettings().setUseWideViewPort(true);
        webViewVideo.getSettings().setSupportMultipleWindows(true);
        webViewVideo.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webViewVideo.setHorizontalScrollBarEnabled(false);
        webViewVideo.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webViewVideo.getSettings().setAllowFileAccessFromFileURLs(true);
        webViewVideo.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webViewVideo.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(progress);
                if (progress == 100) {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
        progressBar.setVisibility(View.VISIBLE);
        webViewVideo.loadUrl("https://www.youtube.com/channel/UC8rXNFgn9Iud0sQBQ7R5Oaw");
        return v;
    }
    @Override
    public void onPause(){
        super.onPause();
        webViewVideo.onPause();
    }

}
