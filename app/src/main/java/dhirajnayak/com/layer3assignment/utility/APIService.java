package dhirajnayak.com.layer3assignment.utility;

import dhirajnayak.com.layer3assignment.model.BodyParams;
import dhirajnayak.com.layer3assignment.model.ResponseData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by dhirajnayak on 1/20/18.
 * interface for api methods.
 */

public interface APIService {
    @POST("notify")
    Call<ResponseData> notify(@Body BodyParams params);
}
