package dhirajnayak.com.layer3assignment.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

import dhirajnayak.com.layer3assignment.model.BodyParams;
import dhirajnayak.com.layer3assignment.model.ResponseData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dhirajnayak on 1/19/18.
 * class that acts as an interface between javascript and android.
 */

public class WebInterface {
    Context context;
    SharedPreferences preferences;
    WebView webView;

    public WebInterface(Context context, WebView webView) {
        this.context = context;
        this.webView = webView;
    }
    @JavascriptInterface
    //method called from javascript function on web client
    public void callNotificationService(String text) {
        preferences=PreferenceManager.getDefaultSharedPreferences(context);
        String deviceID=preferences.getString(Constants.TOKEN,"");
        final BodyParams params=new BodyParams();
        params.setText(text);
        params.setDeviceID(deviceID);
        final String message=text;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(Constants.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService service=retrofit.create(APIService.class);
                Call<ResponseData> call=service.notify(params);
                call.enqueue(new Callback<ResponseData>() {
                    @Override
                    public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                        Toast.makeText(context,"success",Toast.LENGTH_LONG).show();
                        //call javascript function on web client to clear the text box.
                        webView.loadUrl("javascript:reset()");
                    }

                    @Override
                    public void onFailure(Call<ResponseData> call, Throwable t) {
                        Toast.makeText(context,"failure",Toast.LENGTH_LONG).show();
                    }
                });
            }
        }, 0);

    }
}
