package dhirajnayak.com.layer3assignment.utility;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by dhirajnayak on 1/22/18.
 * custom web view client.
 */

public class CustomWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        //preventing app to open the url in browser.
        if (Uri.parse(url).getHost().equals(Constants.BASE_URL)) {
            return false;
        }
        return true;
    }
}