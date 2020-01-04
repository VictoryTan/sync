package com.xdclass.thread;

import com.xdclass.busi.DealBusi;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Consumer implements Runnable{

    private DealBusi dealBusi;
    private LinkedBlockingQueue<Runnable> consumers;
    private List data;

    public Consumer(DealBusi dealBusi, LinkedBlockingQueue<Runnable> consumers) {
        this.dealBusi = dealBusi;
        this.consumers = consumers;
    }

    @Override
    public void run() {
        try {
            dealBusi.deal(data);
        } finally {
            try {
                consumers.put(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
