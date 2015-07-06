/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dazito.retroeventbus.bus.singletons;

import com.dazito.retroeventbus.bus.SyncBus;


/**
 * With this type of Event Bus, the ubscriber will be called in the same thread, 
 * which is posting the event. 
 * This is the default. Event delivery implies the least overhead because it 
 * avoids thread switching completely. Thus this is the recommended mode 
 * for simple tasks that are known to complete is a very short time without 
 * requiring the main thread. Event handlers using this mode must return 
 * quickly to avoid blocking the posting thread, which may be the main thread.
 * 
 * @author Pedro Machado
 * @version 1
 */
public class RetroBus {
    
    private static RetroBus instance = null;
    private final SyncBus syncBus;
    
    private RetroBus() {
        syncBus = new SyncBus();
    }
    
    private RetroBus(String identifier) {
        syncBus = new SyncBus(identifier);
    }
    
    /**
     * Register in the bus.
     * @param object the object to register
     */
    public void register(Object object) {
        syncBus.register(object);
    }
    
    /**
     * Unregister from the bus.
     * Therefore no more events will be received by the object.
     * @param object to unregister.
     */
    public void unregister(Object object) {
        syncBus.unregister(object);
    }
    
    /**
     * Post an event in the bus.
     * @param object the event to post.
     */
    public void post(Object object) {
        syncBus.post(object);
    }
    
    /**
     * Get a {@link RetroBus}
     * @return {@link RetroBus}
     */
    public synchronized static RetroBus getRetroBus()
    {
        if (instance == null) 
        {
            instance = new RetroBus();
            return instance;
        }
        return instance;
    }
    
    /**
     * Get a {@link RetroBus}
     * @param identifier short name for the bus, for logging purposes.
     * @return {@link RetroBus}
     */
    public synchronized static RetroBus getRetroBus(String identifier)
    {
        if (instance == null) 
        {
            instance = new RetroBus(identifier);
            return instance;
        }
        return instance;
    }
    
}
