class Cell{
  int i, j;
  boolean[] walls = {true, true, true, true};// {top, right, bottom, left}
  boolean visited = false;
  
  Cell(int ii, int jj){
    this.i = ii;
    this.j = jj;
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
    
    if(visited){
      
      noStroke();
      fill(0, 255, 255, 200);
      rect(x, y, w, w);
    }
  }
  
  public Cell checkNeighbors(){
    ArrayList<Cell> neighbors = new ArrayList<Cell>();
    
    Cell top = grid.get(index(i, j - 1));
    Cell right = grid.get(index(i + 1, j));
    Cell bottom = grid.get(index(i, j + 1));
    Cell left = grid.get(index(i - 1, j));

    if(!top.visited && top != null)
      neighbors.add(top);
    if(!right.visited && right != null)
      neighbors.add(right);
    if(!bottom.visited && bottom != null)
      neighbors.add(bottom);
    if(!left.visited && left != null)
      neighbors.add(left);
      

    
    if(neighbors.size() > 0){
      return neighbors.get(floor(random(0, neighbors.size())));
    }
    return null;

  }
  
  public void highlight(){
    int x = i * w;
    int y = j * w;
    noStroke();
    fill(0, 255, 255, 225);
    rect(x, y, w, w);
  }
}
