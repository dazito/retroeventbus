/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dazito.retroeventbus.bus;

import com.google.common.eventbus.EventBus;

/**
 *
 * @author Pedro Machado
 * @version 1
 */
public class SyncBus extends EventBus{
    
    public SyncBus() {
        super();
    }
    
    public SyncBus(String identifier) {
        super(identifier);
    }
    
}
