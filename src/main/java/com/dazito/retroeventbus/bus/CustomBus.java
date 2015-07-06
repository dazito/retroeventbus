/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dazito.retroeventbus.bus;

import com.google.common.eventbus.AsyncEventBus;
import java.util.concurrent.Executor;

/**
 *
 * @author Pedro Machado
 * @version 1
 */
public class CustomBus extends AsyncEventBus{
    
    public CustomBus(Executor executor) {
        super(executor);
    }
    
    public CustomBus(String identifier, Executor executor) {
        super(identifier, executor);
    }
}
