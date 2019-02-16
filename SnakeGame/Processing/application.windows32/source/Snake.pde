class Snake {


  int x = 0;
  int y = 0;
  int xSpeed = 1;
  int ySpeed = 0;

  int total = 0;
  ArrayList<PVector> tail = new ArrayList<PVector>();

  public void update() {
    
    death();
    
    addTail();
    
    x += xSpeed * SnakeGame.scale;
    y += ySpeed * SnakeGame.scale;

    x = constrain(x, 0, width - SnakeGame.scale);
    y = constrain(y, 0, height - SnakeGame.scale);
  }

  public void show() {
    fill(255);
    for (PVector v : tail) {
      rect(v.x, v.y, SnakeGame.scale, SnakeGame.scale);
    }
    rect(x, y, SnakeGame.scale, SnakeGame.scale);
  }

  public void death(){
    float d;
    for(PVector t : tail){
      d = dist(x, y, t.x, t.y);
      
      if (d < 1){
        total = 0;
        tail = new ArrayList<PVector>();
      }
      
    }
  }
  
  public void addTail(){
    if (total > 0) {
      if (total == tail.size() && !tail.isEmpty()) {
        tail.remove(0);
      }
      tail.add(new PVector(x, y));
    }
  }


  public void dir(int x, int y) {
    xSpeed = x;
    ySpeed = y;
  }

  public boolean eat(Food food) {
    float dis = dist(x, y, food.x, food.y);

    if (dis < 2) {
      total++;
      return true;
    }

    return false;
  }
}
