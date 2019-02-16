class RainDrop{
  
  float x = random(width);
  float y = random(-500, -50);
  float z = random(0, 20);
  
  float ySpeed = map(z, 0, 20, 4, 10);
  float len = map(z, 0, 20, 10, 20); 
  float thick = map(z, 0, 20, 1, 3);
  
  void fall(){
  y = y + ySpeed;  
  
  if(y > height)
    y = random(-200, -100 );
}
  
  void show(){
    strokeWeight(thick);
    stroke(77, 143, 218);
    line(x, y, x, y+len);
  }

}
