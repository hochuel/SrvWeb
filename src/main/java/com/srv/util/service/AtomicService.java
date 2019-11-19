package com.srv.util.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AtomicService {

    private AtomicInteger atomicInteger = null;

    public AtomicService(){
        atomicInteger = new AtomicInteger();

    }

    public int getIntData(){

        int index = atomicInteger.incrementAndGet();

        if(index > 9000){
            atomicInteger = new AtomicInteger(0);
            index = atomicInteger.incrementAndGet();
        }

        return index;
    }
}
