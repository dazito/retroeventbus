/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dazito.retroeventbus.bus.singletons;

import com.dazito.retroeventbus.bus.CustomBus;
import java.util.concurrent.Executor;

/**
 *
 * @author Pedro Machado
 * @version 1
 */
public class RetroCustomBus {
    
    private static RetroCustomBus instance = null;
    private final CustomBus customBus;
    
    
    private RetroCustomBus(Executor executor) {
        customBus = new CustomBus(executor);
    }
    
    private RetroCustomBus(String identifier, Executor executor) {
        customBus = new CustomBus(identifier, executor);
    }
    
    public void register(Object object) {
        customBus.register(object);
    }
    
    public void unregister(Object object) {
        customBus.unregister(object);
    }
    
    public void post(Object object) {
        customBus.post(object);
    }
    
    
    public synchronized static RetroCustomBus getRetroCustomBus(Executor executor)
    {
        if (instance == null) 
        {
            instance = new RetroCustomBus(executor);
            return instance;
        }
        return instance;
    }
    
    public synchronized static RetroCustomBus getRetroCustomBus(String identifier, Executor executor)
    {
        if (instance == null) 
        {
            instance = new RetroCustomBus(identifier, executor);
            return instance;
        }
        return instance;
    }
}
    