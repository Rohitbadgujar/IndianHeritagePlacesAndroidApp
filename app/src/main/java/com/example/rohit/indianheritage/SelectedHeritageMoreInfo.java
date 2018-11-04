package com.example.rohit.indianheritage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import static com.example.rohit.indianheritage.R.id.activity_main_webview;


public class SelectedHeritageMoreInfo extends AppCompatActivity {

    private TextView nameTextView = null;
    private TextView informationTextView = null;
    private TextView addressTextView = null;
    private TextView urlTextView = null;

    private Button webInfoButton;
    private Intent intent = null;

    private HeritageDetails data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_information);

        // get data from intent
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        data = (HeritageDetails) bundle.getSerializable("data");

        //wire and populate the fieldswith data.getName() etc
        nameTextView    = findViewById(R.id.textView5);
        addressTextView = findViewById(R.id.textView3);
        urlTextView     = findViewById(R.id.textView2);
        informationTextView = findViewById(R.id.textView4);

        nameTextView.setText(data.getName());
        addressTextView.setText(data.getAddress());
        urlTextView.setText(data.getUrl());
        informationTextView.setText(data.getInformation());
        webInfoButton = findViewById(R.id.button2);

        webInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), RedirectWebView.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", data);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();

            }
        });

        /*webInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DEBUG", "webview called");
                String easyPuzzle  = data.getUrl();
                Log.d("DEBUG", "webview called 2");
                Intent i = new Intent (SelectedHeritageMoreInfo.this, RedirectWebView.class);
                Log.d("DEBUG", "webview called 3");
                i.putExtra("puzzle", easyPuzzle);
                Log.d("DEBUG", "webview called 4");
                startActivity(i);
                Log.d("DEBUG", "webview called 5");

            }
        });*/


    }

}