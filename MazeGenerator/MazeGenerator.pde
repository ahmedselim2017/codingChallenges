int rows, cols;
int w = 20;
Cell current;
ArrayList<Cell> grid = new ArrayList<Cell>();
ArrayList<Cell> stack = new ArrayList<Cell>();

public void setup(){
  size(600,600);
  cols = floor(width / w);
  rows = floor(height / w);
  //frameRate(5);
  
  for(int j = 0; j < rows; j++){
    for(int i = 0; i < cols; i++){
        Cell c = new Cell(i,j);
        grid.add(c);
      }
  }
  current = grid.get(0);
}

public void draw(){
  background(51);
 
  for(int i = 0; i < grid.size(); i++){
    grid.get(i).show();
  }
  
  current.visited = true;
  current.highlight();
  Cell next = current.checkNeighbors();
  
  if(next != null){
    next.visited = true;
    stack.add(current);
    removeWalls(current, next);
    current = next;
  }
  else if(stack.size() > 0){
    current = stack.remove(stack.size() - 1);
  }
  
}

public int index(int i, int j){
  if(i < 0 || j < 0 || i > cols - 1 || j > rows - 1)
    return 0;
  return  i+ j * cols;
}

public void removeWalls(Cell a, Cell b){
 int x = a.i - b.i;
 int y = a.j - b.j;
 
 switch(x){
   case 1:
     a.walls[3] = false; // remove the left wall of a
     b.walls[1] = false; // remove the rigth wall of b 
   case -1:
     a.walls[1] = false; // remove the rigth wall of a
     b.walls[3] = false; // remove the left wall of b        
 }
 switch(y){
   case 1:
     a.walls[0] = false; // remove the top wall of a
     b.walls[2] = false; // remove the bottom wall of b 
   case -1:
     a.walls[2] = false; // remove the bottom wall of a
     b.walls[0] = false; // remove the top wall of b        
 }  
}
