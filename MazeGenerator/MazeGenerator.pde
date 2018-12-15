int rows, cols;
int w = 40;
Cell current;
ArrayList<Cell> grid = new ArrayList<Cell>();

public void setup(){
  size(400,400);
  cols = floor(width / w);
  rows = floor(height / w);
  frameRate(5);
  
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
  Cell next = current.checkNeighbors();
  if(next != null){
    next.visited = true;
    current = next;
  }
  
}

public int index(int i, int j){
  if(i < 0 || j < 0 || i > cols - 1 || j > rows - 1)
    return 0;
  return  i+ j * cols;
}
