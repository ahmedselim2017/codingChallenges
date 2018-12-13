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

public class Rain extends PApplet {

// rgb(77, 143, 218)
// rgb(204, 220, 241) background

  RainDrop[] drops=new RainDrop[400];
  RainDrop d;
  
public void setup(){
  
  
  for(int i = 0; i < drops.length; i++){
      d = new RainDrop();
      drops[i] = d;
  }
}

public void draw(){
  background(204, 220, 241);
  
  for(int i = 0; i < drops.length; i++){
      d = drops[i];
      
      d.fall();
      d.show();
  }
}
class RainDrop{
  
  float x = random(width);
  float y = random(-500, -50);
  float z = random(0, 20);
  
  float ySpeed = map(z, 0, 20, 4, 10);
  float len = map(z, 0, 20, 10, 20); 
  float thick = map(z, 0, 20, 1, 3);
  
  public void fall(){
  y = y + ySpeed;  
  
  if(y > height)
    y = random(-200, -100 );
}
  
  public void show(){
    strokeWeight(thick);
    stroke(77, 143, 218);
    line(x, y, x, y+len);
  }

}
  public void settings() {  size(640, 360); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Rain" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
