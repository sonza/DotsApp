package com.example.sonza.dotsfinal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tx = (TextView)findViewById(R.id.textview);
        TextView presents=(TextView)findViewById(R.id.presents);
        TextView tag=(TextView)findViewById(R.id.tag);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/LobsterTwo-Regular.otf");
        Typeface custome_font2= Typeface.createFromAsset(getAssets(),  "fonts/DroidSans.ttf");
        tx.setTypeface(custom_font);
        presents.setTypeface(custome_font2);
        tag.setTypeface(custom_font);
    }
    public void start(View view){
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
    }

    public void instruct(View view){
        Intent intent=new Intent(this,Instructions.class);
        startActivity(intent);
    }


}

