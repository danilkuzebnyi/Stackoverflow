package org.danylo.api;

import org.danylo.model.StackoverflowResponse;
import org.danylo.model.StackoverflowTag;
import org.danylo.model.StackoverflowUser;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import java.util.Map;

public interface StackoverflowApi {
    String BASE_URL = "https://api.stackexchange.com/2.3/";

    @GET("users")
    Call<StackoverflowResponse<StackoverflowUser>> getUsers(@QueryMap Map<String, String> queryParameters);

    @GET("users/{id}/tags")
    Call<StackoverflowResponse<StackoverflowTag>> getUserTags(@Path("id") String id, @QueryMap Map<String, String> queryParameters);

    static StackoverflowApi getApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(StackoverflowApi.class);
    }
}
