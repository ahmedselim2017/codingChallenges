//EuzuBillahimineşşeydanirracim Bismillahirrahmanirrahim

float  time = 0;


ArrayList<Float> wave = new ArrayList<Float>();


public void setup(){
    size(600,400);
    background(0);

}

public void draw(){
    background(0);
    translate(150,200);


    float x = 0;
    float y = 0;
    float radius = 0;

    for(int i = 1; i<100; i++){

        float prevx = x;
        float prevy = y;
        float n = i * 2 + 1;
        if (i % 2 != 0){
            radius = 75 * (2 / ( -i * PI));
        }
        else{
            radius = 75 * (2 / ( i * PI));
        }
        x += radius * cos(i * time);
        y += radius * sin(i * time);


        stroke(255, 100);
        noFill();
        ellipse(prevx,prevy,radius*2,radius*2);



        //fill(255);
        stroke(255);

        line(prevx,prevy, x,y);
        //ellipse(x,y,8,8);




    }
    wave.add(0,y);
    translate(200,0);
    line(x - 200, y,0, wave.get(0));

    beginShape();
    noFill();
    for(int i = 0; i< wave.size(); i++){
        vertex(i,  wave.get(i));
    }
    endShape();

    time -= 0.05;

    if(wave.size() > 250){
        wave.remove(wave.size()-1);
    }


}
