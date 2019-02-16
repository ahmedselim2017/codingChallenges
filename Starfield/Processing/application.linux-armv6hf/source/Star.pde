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
