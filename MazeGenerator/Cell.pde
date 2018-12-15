class Cell{
  int i, j;
  //                top, right, bottom, left
  boolean[] walls = {true, true, true, true};
  
  Cell(int i, int j){
    this.i = i;
    this.j = j;
  }
  
  public void show(){
    int x = i * w;
    int y = j * w;
    stroke(255);
    
    if(walls[0])
      line(x    , y    , x + w, y    );
    if(walls[1])
      line(x + w, y    , x + w, y + w);
    if(walls[2])
      line(x + w, y + w, x , y + w);
    if(walls[3])
      line(x    , y + w, x    , y    );
    

  }
  
}
