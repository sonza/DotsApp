package com.example.sonza.dotsfinal;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Instructions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        TextView title = (TextView)findViewById(R.id.title1);
        TextView inst=(TextView)findViewById(R.id.inst);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/LobsterTwo-Regular.otf");
        Typeface custome_font2= Typeface.createFromAsset(getAssets(),  "fonts/DroidSans.ttf");
        title.setTypeface(custom_font);
        inst.setTypeface(custome_font2);
    }
}
