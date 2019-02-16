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

public class Clock extends PApplet {


public void setup(){
  
  background(0);
}

public void draw(){
  background(0);
  translate(200, 200);
  rotate(radians(-90));
  int hr = hour();
  int mn = minute();
  int sc = second();
  float hrAngle = map(hr % 12, 0, 12, 0, 360);;
  float mnAngle = map(mn, 0, 60, 0, 360);
  float scAngle = map(sc, 0, 60, 0, 360);

  
  strokeWeight(10);
  noFill();
  
  stroke(255, 100, 150);
  arc(0, 0, 300, 300, radians(0), radians(scAngle));
  
  strokeWeight(10);
  stroke(150, 100, 255);
  arc(0, 0, 270, 270, radians(0), radians(mnAngle));
  
  strokeWeight(10);
  stroke(150, 255, 100);
  arc(0, 0, 240, 240, radians(0), radians(hrAngle));
  
  
  
  pushMatrix();
  stroke(255, 100, 150);
  strokeWeight(2);
  rotate(radians(scAngle));
  line(0,0,100,0);
  popMatrix();
  
  pushMatrix();
  strokeWeight(3);
  stroke(150, 100, 255);
  rotate(radians(mnAngle));
  line(0,0,85,0);
  popMatrix();

  pushMatrix();
  strokeWeight(4);
  stroke(150, 255, 100);
  rotate(radians(hrAngle));
  line(0,0,75,0);
  popMatrix();
  
  
  rotate(radians(90));  
  pushMatrix();
  textSize(25);
  textAlign(CENTER);
  fill(77,238,234);
  text(hr + " : " + mn + " : " + sc, 0, 200);
  popMatrix();
}
  public void settings() {  size(400,450); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Clock" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
