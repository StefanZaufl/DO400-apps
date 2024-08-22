package com.redhat.shipping;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ShippingCalculator {
    public static final Map<String, Integer> REGIONS;

    static {
        var regions = new HashMap<String, Integer>();
        regions.put("NA", 100);
        regions.put("LATAM", 200);
        regions.put("EMEA", 300);
        regions.put("APAC", 400);

        REGIONS = Collections.unmodifiableMap(regions);
    }


    public int costForRegion(String region) throws RegionNotFoundException {
        if(REGIONS.containsKey(region)) {
            return REGIONS.get(region);
        } else {
            throw new RegionNotFoundException();
        }
    }
}
