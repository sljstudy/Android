package net.itjh.retrofitdemo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private Button requestButton;

    private static Retrofit retrofit;
    private static TestService apiService;
    private static OkHttpClient okHttpClient;
    private static String URL_BASE = "http://192.168.199.111:8921/v2.1/rest/";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

//    Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl(URL_BASE)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();

//    public static TestService getApiService() {
//        if (apiService == null) {
//            apiService = getRetrofit().create(TestService.class);
//        }
//        return apiService;
//    }
//
    private static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
//
//    private static OkHttpClient getClient() {
//
//        if (okHttpClient == null) {
//            okHttpClient = new OkHttpClient.Builder()
//                    .addInterceptor(new Interceptor() {
//                        @Override
//                        public Response intercept(Chain chain) throws IOException {
//                            Request request = chain.request().newBuilder().build();
//                            return chain.proceed(request);
//                        }
//                    })
//                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//                    .build();
//        }
//        return okHttpClient;
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        requestButton = (Button) findViewById(R.id.button);

        requestButton.setOnClickListener(mSendClickListener);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public static ResponseEntity parseError(Response<?> response) {
        Converter<ResponseBody, ResponseEntity> converter =
                retrofit
                        .responseBodyConverter(ResponseEntity.class, new Annotation[0]);

        ResponseEntity error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new ResponseEntity();
        }

        return error;
    }

    private View.OnClickListener mSendClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            Log.d("check -> ", "点击了REQUEST");
//            getClient();
            new Thread() {
                public void run() {
                    try {
//
//                        getRetrofit();




                        TestService service = getRetrofit().create(TestService.class);

                        Call<ResponseEntity> call = service.verifyCode("18626893929", "1234");

                        call.enqueue(new Callback<ResponseEntity>() {
                            @Override
                            public void onResponse(Call<ResponseEntity> call, Response<ResponseEntity> response) {

                                Log.d("response.isSuccessful() -> ", response.isSuccessful() + "");

                                if (response.isSuccessful()) {

                                    // use response data and do some fancy stuff :)

                                    int statusCode = response.code();
                                    ResponseEntity responseEntity = response.body();
                                    Log.d("statusCode -> ", statusCode + "");
                                    Log.d("responseEntity -> ", responseEntity + "");

                                } else {



                                    int statusCode = response.code();
                                    ResponseEntity errorResponseEntity = parseError(response);

                                    response.errorBody();
                                    Log.d("statusCode -> ", statusCode + "");
                                    Log.d("errorResponseEntity ", errorResponseEntity + "");

                                }

                            }

                            @Override
                            public void onFailure(Call<ResponseEntity> call, Throwable t) {


                                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

                            }

                        });


//                        call.enqueue(new Callback<ResponseEntity>() {
//                            @Override
//                            public void onResponse(Call<ResponseEntity> call, Response<ResponseEntity> response) {
//                                int statusCode = response.code();
//                                ResponseEntity responseEntity = response.body();
//
//                                Log.d("statusCode -> " , statusCode + "");
//                                Log.d("responseEntity -> " , responseEntity + "");
//
//
//                            }
//
//                            @Override
//                            public void onFailure(Call<ResponseEntity> call, Throwable t) {
//
//                            }
//
//
//                        });

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                    handler.sendEmptyMessage(0x002);
                }

                ;
            }.start();
        }
    };

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://net.itjh.retrofitdemo/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://net.itjh.retrofitdemo/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
