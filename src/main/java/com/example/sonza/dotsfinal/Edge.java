package com.example.sonza.dotsfinal;

/**
 * Created by sonza on 07-05-2017.
 */

public class Edge {
    int pointOne,pointTwo;        //box ids are numbered 00,01,02
    boolean horEdge=false;
    int id1,id2;
    boolean topCornerEdge,bottomCornerEdge;


    public Edge(int one,int two){
        pointOne=one;
        pointTwo=two;
        if(Math.abs(pointOne-pointTwo)==1)
            horEdge=true;
        checkCornerEdge();
        findBox();

    }
    void findBox(){                                 //finds which box an edge belongs to
        if(!topCornerEdge && !bottomCornerEdge) {      //if box lies in interior
            id1 = Math.min(pointOne, pointTwo);
            if (horEdge)
                id2 = id1 - 10;
            else if(!horEdge)                                  //vertical edge
                id2 = id1 - 1;
        }
        if(topCornerEdge){                             //if box is part of __
            id1=Math.min(pointOne,pointTwo);           //                 |
            id2=-1;

        }
        if(bottomCornerEdge){                          //if box is part of _|
            if(horEdge)
                id1=Math.min(pointOne,pointTwo)-10;
            else                                     //vertical edge
                id1=Math.min(pointOne,pointTwo)-1;
            id2=-1;
        }
    }

    void checkCornerEdge(){
        if(((pointOne % 10 ==0)&&(pointTwo%10==0)) || (pointOne<=4 && pointTwo<=4))
            topCornerEdge=true;
        else if((pointOne >=50 && pointTwo>=50) || (pointOne % 10==4 && pointTwo %10==4))
            bottomCornerEdge=true;
    }
}
