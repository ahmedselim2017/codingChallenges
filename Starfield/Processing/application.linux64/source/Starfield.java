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

public class Starfield extends PApplet {

Star[] stars=new Star[800];

public void setup(){
    
  for(int i = 0; i<stars.length; i++){
    stars[i]=new Star();
  } 
}

public void draw(){
  background(0);
  
  translate(width/2,height/2);
  
  for(int i = 0; i<stars.length; i++){
    stars[i].update();
    stars[i].show();
  } 
}
class Star{
  
  float speed = 20;
  
  float x = random(-width, width);
  float y = random(-height, height);
  float z = random(width) ;
  float r;

  float sx;
  float sy;
  
  float px;
  float py;
  float pz = z;
    


  protected void update(){
    z -= speed;
    
    if(z<1){
      z=random(width);
      
      x = random(-width, width);
      y = random(-height, height);

      pz = z;

    }
  }

  protected void show(){
    fill(255);
    noStroke();
    
    sx = map(x / z, 0, 1, 0, width);
    sy = map(y / z, 0, 1, 0, height);
    
    r = map(z, 0, width, 16, 0);
    
    ellipse(sx, sy, r, r);
    
    px = map(x / pz, 0, 1, 0, width);    
    py = map(y / pz, 0, 1, 0, width);
    
    
    stroke(255);
    line(px,py,sx,sy);
    

  }

}
  public void settings() {  size(800, 800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
