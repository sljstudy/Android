package net.itjh.testhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button requestButton;

    // 基本地址：服务器ip地址：端口号/Web项目逻辑地址+目标页面（Servlet）的url-pattern
    private String baseURL = "http://www.baidu.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        requestButton = (Button) findViewById(R.id.button);
        requestButton.setOnClickListener(mSendClickListener);


    }


    private OnClickListener mSendClickListener = new OnClickListener()
    {

        @Override
        public void onClick(View v)
        {
//            try {
//                URL url = new URL("http://www.baidu.com/");
//                HttpURLConnection urlConnection = null;
//
//                try {
//                    urlConnection = (HttpURLConnection) url.openConnection();
//
//
//                    urlConnection
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }finally {
//                    urlConnection.disconnect();
//                }
//
//
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }


            new Thread() {
                public void run() {
                    try {
                       String detail = GetData.getHtml("http://192.168.199.111:8921/v2.1/rest/util/verifyCode/18626893929/4557");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                    handler.sendEmptyMessage(0x002);
                };
            }.start();

        }
    };


}