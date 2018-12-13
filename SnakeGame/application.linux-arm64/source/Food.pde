class Food{
  
  int cols = floor(width / SnakeGame.scale);
  int rows = floor(height / SnakeGame.scale);
  
  float x = floor(random(cols))*SnakeGame.scale;
  float y = floor(random(rows))*SnakeGame.scale;
    

  
  public void show(){
    fill(255, 0, 100);
    rect(x, y, SnakeGame.scale, SnakeGame.scale);
  }


  public void pickLocation(){
    x = floor(random(cols))*SnakeGame.scale;
    y = floor(random(rows))*SnakeGame.scale;
  }

  


}
