package com.example.sonza.dotsfinal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by sonza on 06-05-2017.
 */

public class DrawView extends View {

    Paint paint = new Paint();
    View startView,endView;
    int sx,sy,ex,ey;

    public DrawView(Context context,View startView,View endView,int sx,int sy,int ex,int ey,boolean userTurn){
        super(context);
        if(userTurn==true){ //1st users turn
            paint.setColor(Color.MAGENTA);
        }
        else if(userTurn==false){ //2nd user turn
            paint.setColor(Color.CYAN);
        }
        paint.setStrokeWidth(20);
        this.startView=startView;
        this.endView=endView;
        this.sx=sx;
        this.sy=sy;
        this.ex=ex;
        this.ey=ey;
    }

    public void onDraw(Canvas canvas){
        float x1=startView.getX()+sx;
        float y1=startView.getY()+sy;
        float x2=endView.getX()+ex;
        float y2=endView.getY()+ey;
        canvas.drawLine(x1,y1,x2,y2,paint);

    }

}
