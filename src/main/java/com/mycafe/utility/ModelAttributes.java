package com.mycafe.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelAttributes {
    public static final Map<String, String> prepareWaiters(){
        Map<String, String> waiters = new HashMap<>();
        waiters.put("Garson 1", "Garson 1");
        waiters.put("Garson 2", "Garson 2");
        waiters.put("Garson 3", "Garson 3");
        return waiters;
    }
}
