package com.scaler.bookmyshow;

public class Adder implements Runnable {

    private Counter counter;

    public Adder(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(var i=0;i<1000;i++){
            this.counter.addValue(1);
        }
    }
}
