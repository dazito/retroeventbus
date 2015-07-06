/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dazito.retroeventbus.bus.singletons;

import com.dazito.retroeventbus.bus.AsyncBus;

/**
 * With a RetroAsyncBus, event handler methods are called in a separate thread. 
 * This is always independent from the posting thread and the main thread. 
 * Posting events never wait for event handler methods using this mode. 
 * Event handler methods should use this mode if their execution might take some time, 
 * e.g. for network access. 
 * Avoid triggering a large number of long running asynchronous  
 * methods at the same time to limit the number of concurrent threads but 
 * this is totally up to you.
 * 
 * @author Pedro Machado
 * @version 1
 */
public class RetroAsyncBus {
    
    private static RetroAsyncBus instance = null;
    private final AsyncBus asyncBus;
    
    
    private RetroAsyncBus() {
        asyncBus = new AsyncBus();
    }
    
    private RetroAsyncBus(String identifier) {
        asyncBus = new AsyncBus(identifier);
    }
    
    /**
     * Register in the bus.
     * @param object the object to register
     */
    public void register(Object object) {
        asyncBus.register(object);
    }
    
    /**
     * Unregister from the bus.
     * Therefore no more events will be received by the object.
     * @param object to unregister.
     */
    public void unregister(Object object) {
        asyncBus.unregister(object);
    }
    
    /**
     * Post an event in the bus.
     * @param object the event to post.
     */
    public void post(Object object) {
        asyncBus.post(object);
    }
    
    /**
     * Get a {@link RetroAsyncBus}
     * @return {@link RetroAsyncBus}
     */
    public synchronized static RetroAsyncBus getRetroAsyncBus()
    {
        if (instance == null) 
        {
            instance = new RetroAsyncBus();
            return instance;
        }
        return instance;
    }
    
    /**
     * Get a {@link RetroAsyncBus}
     * @param identifier short name for the bus, for logging purposes.
     * @return {@link RetroAsyncBus}
     */
    public synchronized static RetroAsyncBus getRetroAsyncBus(String identifier)
    {
        if (instance == null) 
        {
            instance = new RetroAsyncBus(identifier);
            return instance;
        }
        return instance;
    }
    
}
