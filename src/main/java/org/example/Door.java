package org.example;

import java.util.Random;

public class Door {
    static int flagCounter = 0;
    int id = 0;
    boolean flag;
    static int counter = 1;


    Door(){
        this.id += counter;
        this.flag = setRandomFlag();
        counter++;
    }

    private boolean setRandomFlag(){
        Random random = new Random();
        if (flagCounter == 0){
            this.flag = random.nextBoolean();
            if(this.flag){
                flagCounter++;
            }
        }else{
            this.flag = false;
        }
        return getFlag();
    }

    public boolean getFlag(){
        return this.flag;
    }

    public void setFlag(boolean flag){
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Door{" +
                "id=" + id +
                ", flag=" + flag +
                '}';
    }
}
