import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import peasy.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SolarSystem extends PApplet {



PeasyCam cam;
Planet sun;
PImage sunTexture;
PImage[] textures = new PImage[3];

public void setup(){
  
  
  sunTexture = loadImage("TextureMaps/Sun.jpg");
  textures[0] = loadImage("TextureMaps/Earth.jpg");
  textures[1] = loadImage("TextureMaps/Mars.jpg");
  textures[2] = loadImage("TextureMaps/Mercury.jpg");

  cam = new PeasyCam(this, 500);
  sun = new Planet(50, 0, 0, sunTexture);
  sun.spawnMoons(4, 1);
}

public void draw(){
  background(0);
  int z = 100;
  for (int i = 0; i<2; i++){
    z = -z;
    pointLight(255, 255, 255, -100, -100, z);
    pointLight(255, 255, 255, 100, -100, z);
    pointLight(255, 255, 255, 100, 100, z);
    pointLight(255, 255, 255, -100, 100, z);
  }
    
  sun.show();
  sun.orbit();
}
class Planet{
  
  float radius;
  float distance;
  float angle;
  float orbitSpeed;
  PVector v;
  PShape globe;
  
  Planet[] planets;
  
  Planet(float r, float d, float o, PImage image){
    v = PVector.random3D();
    this.radius = r;
    this.distance = d;  
    v.mult(distance);
    this.angle = random(TWO_PI);
    this.orbitSpeed = o;
    
    noStroke();
    globe = createShape(SPHERE, radius);
    globe.setTexture(image);
  }
  
  public void show(){
    pushMatrix();    
    noStroke();
    fill(255);  
    
    PVector v2 = new PVector(1,0,1);    
    PVector p = v.cross(v2);
    rotate(angle, p.x, p.y, p.z);
    translate(v.x,v.y,v.z);
    
    shape(globe);
    
    if(planets != null){
      for(int i = 0; i < planets.length; i++){
        planets[i].show();
      }
    }
    popMatrix();
  }
  
  
  public void spawnMoons(int total, int level){
    planets = new Planet[total];
    
    float r, d, o;
    for(int i = 0; i < planets.length; i++){
      r = radius / (level * 2);
      d = random(radius + r, (radius + r) * 2);
      o = random(-0.1f, 0.1f);
      planets[i] = new Planet(r , d , o, textures[(int) random(0, textures.length)] );
      
      if(level < 2)
        planets[i].spawnMoons((int) random(0, 3), level + 1); 
    }
    
  }
  
  
  public void orbit(){
    angle += orbitSpeed;  
    if(planets != null){
      for(int i = 0; i < planets.length; i++){
        planets[i].orbit();
      }
    } 
  }
  
}
  public void settings() {  size(600, 600, P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SolarSystem" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
