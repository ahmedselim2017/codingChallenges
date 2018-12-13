// rgb(77, 143, 218)
// rgb(204, 220, 241) background

  RainDrop[] drops=new RainDrop[400];
  RainDrop d;
  
public void setup(){
  size(640, 360);
  
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
