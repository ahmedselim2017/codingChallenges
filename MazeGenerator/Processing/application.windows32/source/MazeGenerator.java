import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class MazeGenerator extends PApplet {

int rows, cols;
int w = 20;
Cell current;
ArrayList<Cell> grid = new ArrayList<Cell>();
ArrayList<Cell> stack = new ArrayList<Cell>();

public void setup(){
  
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
  public void settings() {  size(600,600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "MazeGenerator" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
