package com.example.sonza.dotsfinal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    DrawView drawView;
    RadioButton[][] myButton= new RadioButton[6][5];
    RelativeLayout rl1;
    boolean areTwoButtonsClicked=true,isWinner;
    int firstButtoni,firstButtonj,secondButtoni,secondButtonj,firstDot,secondDot;
    boolean userTurn=true; //true=user1, false=user2
    Grid grid=new Grid();
    TextView textView;
    int NumButtonClicked=0;
    public String winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        for(int i=0;i<6;i++){
            for(int j=0;j<5;j++){
                String buttonID = "b" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                myButton[i][j] = ((RadioButton) findViewById(resID));

            }
        }
        rl1 =(RelativeLayout)findViewById(R.id.rl1);
        textView=(TextView)findViewById(R.id.text);

    }
    public void onClick(View view){

        int id=view.getId();
        if(NumButtonClicked==0){
            NumButtonClicked++;
            for (int i=0;i<6;i++) {
                for (int j = 0; j < 5; j++) {
                    String buttonID = "b" + i + j;
                    int NumId = Integer.parseInt(""+i+j);
                    int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                    if (id == resID) {
                        firstButtoni = i;
                        firstButtonj = j;
                        firstDot=NumId;
                    }
                }
            }
        }
        else if(NumButtonClicked==1){
            NumButtonClicked--;
            for (int i=0;i<6;i++) {
                for (int j = 0; j < 5; j++) {
                    String buttonID = "b" + i + j;
                    int NumId = Integer.parseInt(""+i+j);
                    int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                    if (id == resID) {
                        secondButtoni = i;
                        secondButtonj = j;
                        secondDot=NumId;
                    }
                }
            }
            if(!(firstDot==secondDot)){
            if(Math.abs(firstDot-secondDot)==1 || Math.abs(firstDot-secondDot)==10){
                Log.v("going into if","yes");
                drawline(myButton[firstButtoni][firstButtonj],myButton[secondButtoni][secondButtonj]);
                grid.makeEdge(firstDot,secondDot,userTurn);
                textView.setText("USER 1:"+grid.user1Score+"    "+"USER 2:"+grid.user2Score);

                if(grid.isWinner){
                    declareWinner();
                }
                if(!grid.extraTurn){
                    userTurn=(!userTurn);
                }
            }
            else{
                Log.v("error so","no edge drawn");
                userTurn=userTurn;
            }

            }

        }
    }

    void declareWinner(){
        textView.setText("Game over! Winner is: "+grid.winner);
    }

    protected void drawline(View a, View b) {
        drawView = new DrawView(Main2Activity.this,a,b,50,50,50,50,userTurn);
        rl1.addView(drawView);
    }

 /*   public void reset(View view){
        textView.setText("");
        rl1.removeAllViewsInLayout();
        //grid.gridMap.clear();
        //grid.user1Score=0;
        //grid.user2Score=0;
        //textView.setText("New Game");
    }
*/

}