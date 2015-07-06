/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dazito.retroeventbus;

import com.dazito.retroeventbus.bus.singletons.RetroAsyncBus;
import com.dazito.retroeventbus.bus.singletons.RetroSwingBus;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;
import javax.swing.SwingUtilities;

/**
 * The Event Queue Executor. Allows to specify the behaviour of an Async Bus,
 * e.g. a {@link  RetroAsyncBus} and {@link RetroSwingBus}
 * @author Pedro Machado
 * @version 1
 */
public class EventQueueExecutor implements Executor {
 
    private final ExecutorType executorType;
            
    public enum ExecutorType 
    {
       SWING_MAIN_THREAD(1), POSTING_THREAD(2), NEW_THREAD(3);
       private final int value;

       private ExecutorType(int value) {
           this.value = value;
       }
    };   
    
    public EventQueueExecutor(ExecutorType threadType) {
        this.executorType = threadType;
    }
    
    @Override 
    public void execute(Runnable runnable) {
        switch(executorType) {
            case SWING_MAIN_THREAD:
                SwingUtilities.invokeLater(runnable);
                break;
            case POSTING_THREAD:
                MoreExecutors.sameThreadExecutor().submit(runnable);
                break;
            case NEW_THREAD:
                new Thread(runnable).start();
                break;
        }
    }
}
