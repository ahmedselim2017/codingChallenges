
Snake snake;
Food food;
static final int scale = 20;


public void setup(){
  size(600, 600);
  frameRate(10); 
  
  snake = new Snake();
  food = new Food();
}



public void draw(){
  background(51); 
 
  snake.update();
  snake.show(); 
  
  food.show();
  
  if(snake.eat(food)){
    food.pickLocation();
  }
}

public void keyPressed(){
  
  if(keyCode == UP)
    snake.dir(0, -1);
  else if(keyCode == DOWN)
    snake.dir(0, 1);
  else if(keyCode == RIGHT)
    snake.dir(1,0);
  else if(keyCode == LEFT)
    snake.dir(-1,0);
  
  
}
