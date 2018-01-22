package dhirajnayak.com.layer3assignment.notification_service;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import dhirajnayak.com.layer3assignment.utility.Constants;

/**
 * Created by dhirajnayak on 1/17/18.
 * get device id
 */

public class InstanceIdService extends FirebaseInstanceIdService {

    String token="";
    @Override
    public void onTokenRefresh() {
        token= FirebaseInstanceId.getInstance().getToken();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        preferences.edit().putString(Constants.TOKEN, token).apply();
    }
}
