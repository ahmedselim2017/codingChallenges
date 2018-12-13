
float a = 0;
ArrayList<Box> sponge;
ArrayList<Box> next;
public void setup(){
  size(400, 400, P3D);
  
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
  rotateY(a*0.4);
  rotateZ(a*0.1);
  
  for(Box box : sponge){
    box.show();
  }
  
  a += 0.01;
  
}
