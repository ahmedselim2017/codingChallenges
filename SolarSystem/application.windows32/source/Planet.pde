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
      o = random(-0.1, 0.1);
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
