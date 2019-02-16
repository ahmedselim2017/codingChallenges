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

public class SnakeGame extends PApplet {


Snake snake;
Food food;
static final int scale = 20;


public void setup(){
  
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
  public void settings() {  size(600, 600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnakeGame" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
