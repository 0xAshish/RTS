package com.example.root.rts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView = null;
    private EditText mInputUrl = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInputUrl = (EditText)findViewById(R.id.url_value);
        Button button = (Button)findViewById(R.id.buttonUrl);
        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new HelloWebViewClient());
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String url = mInputUrl.getText().toString();
                mWebView.loadUrl(url);
            }
        });


    }
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
