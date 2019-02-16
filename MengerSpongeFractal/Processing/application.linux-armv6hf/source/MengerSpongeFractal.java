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

public class MengerSpongeFractal extends PApplet {


float a = 0;
ArrayList<Box> sponge;
ArrayList<Box> next;
public void setup(){
  
  
  sponge = new ArrayList<Box>();
  sponge.add(new Box(0, 0, 0, 200));
  
}

public void mousePressed(){
  ArrayList<Box> next = new ArrayList<Box>();
  for (Box box : sponge) {
     next.addAll(box.generate());
  }
  
  sponge = next;
}

public void draw(){

  background(51);
  stroke(255);
  noFill();
  lights();
  
  translate(width / 2, height / 2);
  rotateX(a);
  rotateY(a*0.4f);
  rotateZ(a*0.1f);
  
  for(Box box : sponge){
    box.show();
  }
  
  a += 0.01f;
  
}
class Box{

  PVector pos;
  float r; 
  float newR;
  Box b;
 
  
  
  Box(float x, float y, float z, float r){
    pos =new PVector(x, y, z);
    this.r=r;
  }
  
  
  public ArrayList<Box> generate() {
    ArrayList<Box> boxes = new ArrayList<Box>();
    int sum;
    
    for (int x = -1; x < 2; x++) {
      for (int y = -1; y < 2; y++) {
        for (int z = -1; z < 2; z++) {
          sum = abs(x) + abs(y) + abs(z);
          
          if (sum > 1) {
            newR = r/3;
            b=new Box(pos.x + x * newR, pos.y + y * newR, pos.z + z * newR, newR);
            boxes.add(b);  
          }
        }
      }
    }
    
    return boxes;
  }
  
  public void show(){
    pushMatrix();
    translate(pos.x, pos.y, pos.z);
    noStroke();
    fill(255);
    box(r);
    popMatrix();

}
  
}
  public void settings() {  size(400, 400, P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "MengerSpongeFractal" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
