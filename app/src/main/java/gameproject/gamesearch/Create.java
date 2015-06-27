/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.gamesearch;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 *
 * @author Nox
 */
public class Create {
    private static final String BASE_URL = "http://localhost:3229";
    private ApiService apiService;
    private ApiSend apiSend;

    public Create()
    {
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setConverter(new GsonConverter(gson))
                .setLogLevel(RestAdapter.LogLevel.FULL).setLog(new RestAdapter.Log() {
                    public void log(String msg) {
                        Log.i("MESSAAGE", msg);
                    }
                }).build();
        apiService = restAdapter.create(ApiService.class);
    }
    public ApiService getApiService()
    {
        return apiService;
    }
    public ApiSend getApiSend()
    {
        return apiSend;
    }
}
    
    

