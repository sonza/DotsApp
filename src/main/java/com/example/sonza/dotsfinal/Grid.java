package com.example.sonza.dotsfinal;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sonza on 07-05-2017.
 */

public class Grid {
    int user1Score=0,user2Score=0;
    boolean userTurn;
    boolean extraTurn=false;
    boolean isWinner=false;
    boolean flag=false;
    String winner;
    HashMap<Integer,ArrayList<Edge>> gridMap;           //Map is (box id, list of edges) idk if we really need box objects
    public Grid(){

        gridMap=new HashMap<Integer,ArrayList<Edge>>();
        for (int i=0;i<5;i++){                          //initialises 20 boxes with id's like 00,01,02
            for(int j=0;j<4;j++){
                String s=""+i+j;
                gridMap.put(Integer.parseInt(s),new ArrayList<Edge>());
            }
        }
    }
    void makeEdge(int a,int b,boolean turn){
        userTurn=turn;
        extraTurn=false;
        flag=false;
        Edge edge=new Edge(a,b);                            //makes new edge
        Log.v("IN NEXT CHECK","Edge made");
        ArrayList<Edge> edgeList=gridMap.get(edge.id1);     //gets the first box's edge list
        edgeList.add(edge);                                 //adds the new edge
        Log.v("number of edges in box1",""+edgeList.size());
        checkCompleteBox(edgeList);
        gridMap.put(edge.id1,edgeList);
        if(edge.id2>=0){                                     //if edge is shared with another box, gets second list
            Log.v("IN NEXT CHECK","Edge is part of 2 boxes");
            edgeList=gridMap.get(edge.id2);
            edgeList.add(edge);
            //Log.v("number of edges in box2",""+edgeList.size());
            checkCompleteBox(edgeList);
            if(flag){
                extraTurn=true;
            }
            gridMap.put(edge.id2,edgeList);
        }

    }

    void checkCompleteBox(ArrayList<Edge> list) {
        if(list.size()==4){
            Log.v("A box was made","yes");

            //fill box with colour
            extraTurn=true; //give extra turn
            flag=true;
            //increment user score
            if (userTurn)
                user1Score++;
            else if (!userTurn)
                user2Score++;
            checkWinner();
        }
        else
            extraTurn=false;
    }

    void checkWinner(){
        //20 total number of edges
        if(user1Score+user2Score==20){
            isWinner=true;
            int max=Math.max(user1Score,user2Score);
            if(max==user1Score){
                winner="USER 1";
            }

            else{
                winner="USER 2";
            }
        }
    }

}
