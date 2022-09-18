package com.scaler.bookmyshow;

public class Subtracter implements  Runnable{

    private Counter counter;

    public Subtracter(Counter counter) {
        this.counter = counter;
    }


    @Override
    public void run() {
        for(var i=0;i<1000;i++){
            this.counter.subtractValue(1);
        }
    }
}
