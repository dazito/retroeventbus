/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dazito.retroeventbus;

import com.dazito.retroeventbus.bus.singletons.RetroCustomBus;
import com.dazito.retroeventbus.bus.singletons.RetroAsyncBus;
import com.dazito.retroeventbus.bus.singletons.RetroBus;
import com.dazito.retroeventbus.bus.singletons.RetroSwingBus;
import java.util.concurrent.Executor;

/**
 * This class provides static methods to get a singleton bus object.
 * The available buses are: {@link RetroAsyncBus}, {@link RetroSwingBus},
 * {@link RetroBus} and {@link RetroCustomBus}
 * @author Pedro Machado
 * @version 1
 */
public class BusService {
    
    
    /**
     * Static method to get a singleton RetroAsyncBus
     * @return {@link RetroAsyncBus}
     */
    public static RetroAsyncBus getRetroAsyncBus() {
        return RetroAsyncBus.getRetroAsyncBus();
    }
    
    /**
     * Static method to get a singleton RetroAsyncBus
     * @param identifier short name for the bus, for logging purposes.
     * @return {@link RetroAsyncBus}
     */
    public static RetroAsyncBus getRetroAsyncBus(String identifier) {
        return RetroAsyncBus.getRetroAsyncBus(identifier);
    }
    
    /**
     * Static method to get a singleton CustomBus where you define your Executor.
     * @param executor the {@link Executor} to pass to the RetroAsyncBus
     * @return {@link RetroCustomBus}
     */
    public static RetroCustomBus getCustomBus(Executor executor) {
        return RetroCustomBus.getRetroCustomBus(executor);
    }
    
    /**
     * Static method to get a singleton CustomBus where you define your Executor.
     * @param identifier short name for the bus, for logging purposes.
     * @param executor
     * @return {@link RetroCustomBus}
     */
    public static RetroCustomBus getCustomBus(String identifier, Executor executor) {
        return RetroCustomBus.getRetroCustomBus(identifier, executor);
    }
    
    /**
     * 
     * @return {@link RetroBus}
     */
    /**
     * Static method to get a singleton RetroBus
     * @return {@link RetroBus}
     */
    public static RetroBus getRetroBus() {
        return RetroBus.getRetroBus();
    }
    
    /**
     * Static method to get a singleton RetroBus with an identifier.
     * @param identifier short name for the bus, for logging purposes.
     * @return {@link RetroBus}
     */
    public static RetroBus getRetroBus(String identifier) {
        return RetroBus.getRetroBus(identifier);
    }
    
    /**
     * 
     * @return {@link RetroSwingBus}
     */
    /**
     * Static method to get a singleton RetroSwingBus.
     * @return {@link RetroSwingBus}
     */
    public static RetroSwingBus getRetroSwingBus() {
        return RetroSwingBus.getRetroSwingBus();
    }
    
    /**
     * Static method to get a singleton RetroSwingBus.
     * @param identifier short name for the bus, for logging purposes.
     * @return {@link RetroSwingBus}
     */
    public static RetroSwingBus getRetroSwingBus(String identifier) {
        return RetroSwingBus.getRetroSwingBus(identifier);
    }
    
}
