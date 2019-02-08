//EuzuBillahimineşşeydanirracim Bismillahirrahmanirrahim

PVector[] cities = new PVector[12];
PVector[] bestEver = new PVector[12];

float recordDistance;

public void setup(){
    size(400,300);
    background(0);

    for(int i = 0 ; i < cities.length; i++){
        PVector v = new PVector(random(width - 8),random(height - 8));
        cities[i] = v;
    }

    float d = calcDistance(cities);
    recordDistance = d;
    arrayCopy(cities,bestEver);
}

public void draw(){
    background(0);
    stroke(255);

    for(int i = 0 ; i < cities.length; i++){
        ellipse(cities[i].x, cities[i].y ,8 , 8);
    }

    beginShape();
    noFill();
    strokeWeight(1);
    for(int i = 0 ; i < cities.length; i++){
        vertex(cities[i].x, cities[i].y);
    }
    endShape();

    stroke(255, 0, 255);
    beginShape();
    noFill();
    strokeWeight(4);
    for(int i = 0 ; i < bestEver.length; i++){
        vertex(bestEver[i].x, bestEver[i].y);
    }
    endShape();



    int i =  floor(random(cities.length));
    int j =  floor(random(cities.length));
    swap(cities,i ,j );
    float d = calcDistance(cities);
    if(d < recordDistance){
        recordDistance = d;
        arrayCopy(cities,bestEver);

        print(recordDistance + "\n");
    }
}

public void swap(PVector[] a, int i, int j){
    PVector temp = a[i];
    a[i] = a[j];
    a[j] = temp;
}

public float calcDistance(PVector[] points){
    float sum = 0;
    for(int i = 0; i < points.length - 1; i++){
        float d = dist(points[i].x ,points[i].y ,points[i+1].x ,points[i+1].y);
        sum += d;
    }
    return sum;
}
