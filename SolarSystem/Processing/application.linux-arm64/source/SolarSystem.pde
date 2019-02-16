import peasy.*;

PeasyCam cam;
Planet sun;
PImage sunTexture;
PImage[] textures = new PImage[3];

public void setup(){
  size(600, 600, P3D);
  
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
