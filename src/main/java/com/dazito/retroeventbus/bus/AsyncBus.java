/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dazito.retroeventbus.bus;

import com.dazito.retroeventbus.EventQueueExecutor;
import com.dazito.retroeventbus.EventQueueExecutor.ExecutorType;
import com.google.common.eventbus.AsyncEventBus;

/**
 *
 * @author Pedro Machado
 * @version 1
 */
public class AsyncBus extends AsyncEventBus{

    public AsyncBus() {
        super(new EventQueueExecutor(ExecutorType.NEW_THREAD));
    }
    
    public AsyncBus(String identifier) {
        super(identifier, new EventQueueExecutor(ExecutorType.NEW_THREAD));
    }
    
}
