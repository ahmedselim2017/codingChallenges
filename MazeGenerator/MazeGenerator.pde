

int rows, cols;
int w = 40;

Cell cell;
ArrayList<Cell> grid = new ArrayList<Cell>();

public void setup(){
  size(400,400);
  
  cols = floor(width / w);
  rows = floor(height / w);
  
  for(int j = 0; j < rows; j++){
    for(int i = 0; i < cols; i++){
        cell = new Cell(i, j);
        grid.add(cell);
      }
  }
}

public void draw(){
  background(51);
  
  for(int i = 0; i < grid.size(); i++){
    grid.get(i).show();
  }
}
