package com.example.rohit.indianheritage;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class RedirectWebView extends AppCompatActivity {
    public WebView mWebView = null;
    public HeritageDetails data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("DEBUG", "redirected");
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        Bundle mBundle  = getIntent().getExtras();
        String url = i.getStringExtra("url");

        setContentView(R.layout.activity_web_view);
        // WebSettings webSettings = mWebView.getSettings();
        //webSettings.setJavaScriptEnabled(true);
        mWebView = (android.webkit.WebView) findViewById(R.id.web_view);
        mWebView.getSettings().getJavaScriptEnabled();
        // Log.d("DEBUG", url);
        Log.d( "LOGCAT",""+url );
        if(mBundle != null) {
            mWebView.loadUrl( mBundle.getString( "url" ) );
        }
    }
}
