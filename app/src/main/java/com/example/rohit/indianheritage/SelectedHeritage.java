package com.example.rohit.indianheritage;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SelectedHeritage extends AppCompatActivity {

    private ImageView heritageImageView = null;
    private Button moreInfoButton = null;
    private  Button nextButton = null;
    private TextView title = null;
    private Intent intent = null;
    private int i =0;
    private LinearLayout linearLayout = null;

    private HeritageDetails data = null;
    Bundle bundle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_heritage);

        GridView gridview = (GridView) findViewById(R.id.gridview);

linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        // get data from intent
        Intent intent = getIntent();
        Log.d("DEBUG", "intent made " );
        bundle = intent.getExtras();
        data = (HeritageDetails) bundle.getSerializable("data");
        title = (TextView) findViewById(R.id.textView);
        Log.d("DEBUG", data.getName() );
        title.setText(data.getName());
         //t.setText(data.getName());
        // wire
        heritageImageView = (ImageView) findViewById(R.id.imageView);
        moreInfoButton  = (Button) findViewById(R.id.button);
        gridview.setAdapter(new ImageAdapter(this,data.getName()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(SelectedHeritage.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                switch (data.getName()){

                    case  "Taj Mahal" : Log.d("DEBUG", "po" + position);heritageImageView.setImageResource(ImageAdapter.mThumbIds[position]);
                        //linearLayout.setBackgroundResource(R.drawable.tajmahal6);
                        //linearLayout.setAlpha((float) 0.5);
                        //heritageImageView.setAlpha((float) 1);;
                    break;
                    case  "Qutub Minar" : heritageImageView.setImageResource(ImageAdapter.mThumbIds1[position]);
                        //linearLayout.setBackgroundResource(ImageAdapter.mThumbIds1[position]);
                        break;
                    case  "Red Fort" : heritageImageView.setImageResource(ImageAdapter.mThumbIds2[position]);
                        break;
                    case  "The Sun Temple" : heritageImageView.setImageResource(ImageAdapter.mThumbIds3[position]);
                        break;
                    case  "Ajanta Caves" : heritageImageView.setImageResource(ImageAdapter.mThumbIds4[position]);
                        break;
                }

                // do something here (see next section)
            }
        });

        // set the image from data.image
        String imageName = data.getImage();
        imageName = imageName.substring(0, imageName.indexOf("."));

        int imageResId = getResources().getIdentifier(
                imageName,
                "drawable",
                getPackageName());

        heritageImageView.setImageResource(imageResId);

        moreInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SelectedHeritage.this, SelectedHeritageMoreInfo.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", data);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
      /* nextButton.setOnClickListener(new View.OnClickListener(){
                   @Override
                   public void onClick(View v) {
                       i = i + 1;
                       Log.d("DEBUG", "Next button clicked" );
                       if(i == 1)
                       heritageImageView.setImageResource(R.drawable.tajmahal1);
                       if(i == 3)
                           heritageImageView.setImageResource(R.drawable.tajmahal3);
                       if(i == 4)
                           heritageImageView.setImageResource(R.drawable.tajmahal4);
                   }

       }); */





    }
}
