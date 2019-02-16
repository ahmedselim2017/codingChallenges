import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class FourierSeries extends PApplet {

//EuzuBillahimineşşeydanirracim Bismillahirrahmanirrahim

float  time = 0;


ArrayList<Float> wave = new ArrayList<Float>();


public void setup(){
    
    background(0);
}

public void draw(){
    background(0);
    translate(150,200);


    float x = 0;
    float y = 0;

    for(int i = 0; i<100; i++){

        float prevx = x;
        float prevy = y;

        float n = i * 2 + 1;
        float radius = 75 * (4 / (n * PI));
        x += radius * cos(n * time);
        y += radius * sin(n * time);


        stroke(255, 100);
        noFill();
        ellipse(prevx,prevy,radius*2,radius*2);



        //fill(255);
        stroke(255);

        line(prevx,prevy, x,y);
        //ellipse(x,y,8,8);




    }
    wave.add(0,y);
    translate(200,0);
    line(x - 200, y,0, wave.get(0));

    beginShape();
    noFill();
    for(int i = 0; i< wave.size(); i++){
        vertex(i,  wave.get(i));
    }
    endShape();

    time += 0.05f;

    if(wave.size() > 250){
        wave.remove(wave.size()-1);
    }


}
  public void settings() {  size(600,400); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "FourierSeries" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
