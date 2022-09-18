package com.scaler.bookmyshow;

public class Counter {

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public  synchronized void addValue(int value){
        //this.count+=1;
        this.setCount(this.getCount()+value);
    }

    public synchronized  void subtractValue(int value){
        //this.count-=1;
        this.setCount(this.getCount()-value);
    }
}
