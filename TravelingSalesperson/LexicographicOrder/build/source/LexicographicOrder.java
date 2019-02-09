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

public class LexicographicOrder extends PApplet {

//EuzuBillahimineşşeydanirracim Bismillahirrahmanirrahim
//Algorith --> https://www.quora.com/How-would-you-explain-an-algorithm-that-generates-permutations-using-lexicographic-ordering

int totalCities = 10;
PVector[] cities;
int[] order;
int totalPermutations;
int count = 0;
float recordDistance;
int[] bestEver;

public void setup( ) {
    

    cities = new PVector[totalCities];
    order = new int[totalCities];
    bestEver = new int[totalCities];

    for(int i = 0; i < totalCities; i++){
        PVector v = new PVector(random(width), random(height / 2));
        cities[i] = v;
        order[i] = i;
    }

    float d = calcDistance(cities, order);
    recordDistance = d;
    arrayCopy(order,bestEver);

    totalPermutations = factorial(totalCities);

}

public void draw(){
    background(0);

    stroke(255, 0, 255);
    fill(255, 0, 255);
    for(int i = 0; i < totalCities; i++){
        ellipse(cities[i].x,cities[i].y,8,8);
    }

    stroke(255, 0, 255);
    strokeWeight(3);
    noFill();
    beginShape();
    for(int i = 0; i < totalCities; i++){
        int n = bestEver[i];
        vertex(cities[n].x,cities[n].y);
    }
    endShape();

    translate(0,height/2);
    stroke(255);
    strokeWeight(1);

    fill(255);
    for(int i = 0; i < totalCities; i++){
        ellipse(cities[i].x,cities[i].y,8,8);
    }

    noFill();
    beginShape();
    for(int i = 0; i < totalCities; i++){
        int n = order[i];
        vertex(cities[n].x,cities[n].y);
    }
    endShape();

    float d = calcDistance(cities, order);
    if(d < recordDistance){
        recordDistance = d;
        arrayCopy(order, bestEver);
    }
    nextOrder();
    textSize(32);
    float percent = 100 * ((float) count / (float) totalPermutations);
    text(nf(percent, 0, 2) + "% completed", 20, height / 2 - 50);


}

public void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
}



public float calcDistance(PVector[] points, int[] order) {
    float sum = 0;
    for (int i = 0; i < order.length - 1; i++) {
        int cityAIndex = order[i];
        PVector cityA = points[cityAIndex];
        int cityBIndex = order[i + 1];
        PVector cityB = points[cityBIndex];
        float d = dist(cityA.x, cityA.y, cityB.x, cityB.y);
        sum += d;
    }
    return sum;
}






public void nextOrder(){
    count++;

    //STEP 1 : Find the largest i such that P[i]<P[i+1]. (If there is no such i, P is the last permutation.)
    int largestI = -1;
    for (int i = 0; i < order.length - 1; i++) {
        if (order[i] < order[i + 1]) {
          largestI = i;
        }
    }
    if(largestI == -1){
        noLoop();
        print("finished");
        return;
    }

    //STEP 2 : Find the largest j such that P[i]<P[j].
    int largestJ = -1;
    for (int j = 0; j < order.length; j++) {
        if (order[largestI] < order[j]) {
          largestJ = j;
        }
    }


    //STEP 3 : Swap P[i] and P[j].
    swap(order, largestI, largestJ);

    //STEP 4 : Reverse P[i+1 .. n].
    int size = order.length - largestI - 1;
    int[] endArray = new int[size];
    arrayCopy(order, largestI + 1, endArray, 0, size);
    endArray = reverse(endArray);
    arrayCopy(endArray, 0, order, largestI+1, size);
}



public int factorial(int n) {
  if (n == 1) {
    return 1;
  } else {
    return n * factorial(n - 1);
  }
}
  public void settings() {  size(400, 600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "LexicographicOrder" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
