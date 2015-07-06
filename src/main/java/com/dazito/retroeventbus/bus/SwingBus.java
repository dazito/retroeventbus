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
public class SwingBus extends AsyncEventBus{

    
    public SwingBus(String identifier) {
        super(identifier, new EventQueueExecutor(ExecutorType.SWING_MAIN_THREAD));
    }
    
    public SwingBus() {
        super(new EventQueueExecutor(ExecutorType.SWING_MAIN_THREAD));
    }
    
    
    
}
