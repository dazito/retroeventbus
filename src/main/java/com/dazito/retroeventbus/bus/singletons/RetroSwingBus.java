/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dazito.retroeventbus.bus.singletons;

import com.dazito.retroeventbus.bus.SwingBus;

/**
 * In a RetroSwingBus, the subscriber will be called in Swing's main thread 
 * (sometimes referred 
 * to as Event Dispatch Thread, EDT). If the posting thread is the main 
 * thread, event handler methods will be called directly. 
 * Event handlers using this mode 
 * must return quickly to avoid blocking the main thread.
 * 
 * @author Pedro Machado
 * @version 1
 */
public class RetroSwingBus {
    
    private static RetroSwingBus instance = null;
    private final SwingBus swingBus;
    
    private RetroSwingBus(String identifier) {
        swingBus = new SwingBus(identifier);
    }
    
    private RetroSwingBus() {
        swingBus = new SwingBus();
    }
    
    /**
     * Register in the bus.
     * @param object the object to register
     */
    public void register(Object object) {
        swingBus.register(object);
    }
    
    /**
     * Unregister from the bus.
     * Therefore no more events will be received by the object.
     * @param object to unregister.
     */
    public void unregister(Object object) {
        swingBus.unregister(object);
    }
    
    /**
     * Post an event in the bus.
     * @param object the event to post.
     */
    public void post(Object object) {
        swingBus.post(object);
    }
    
    /**
     * Get a {@link RetroSwingBus}
     * @return {@link RetroSwingBus}
     */
    public synchronized static RetroSwingBus getRetroSwingBus()
    {
        if (instance == null) 
        {
            instance = new RetroSwingBus();
            return instance;
        }
        return instance;
    }
    
    /**
     * Get a {@link RetroSwingBus}
     * @param identifier short name for the bus, for logging purposes.
     * @return {@link RetroSwingBus}
     */
    public synchronized static RetroSwingBus getRetroSwingBus(String identifier)
    {
        if (instance == null) 
        {
            instance = new RetroSwingBus(identifier);
            return instance;
        }
        return instance;
    }
    
}
