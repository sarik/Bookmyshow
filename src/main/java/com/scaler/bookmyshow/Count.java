package com.scaler.bookmyshow;

public class Count
{

    long count;

    public void setCount(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    synchronized void increment(){
        this.setCount(this.getCount()+1);
    }

    void incrementwithoutsync(Count count){

        synchronized (this){
            this.setCount(this.getCount()+1);
        }

    }
}
