package model;

import java.util.HashMap;

interface LongDistanceCall {
    float calculateCost(int duration, String site, HashMap<String, Float> Rates);
}
