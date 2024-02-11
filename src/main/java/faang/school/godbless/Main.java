package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, House> housesMap = new HashMap<>();
        housesMap.put("Starks", new House("Winterfall", "Wolf"));
        housesMap.put("Lanister", new House("Casterly", "Lion"));
        housesMap.put("Barateon", new House("Dragon Stone", "Three-headed Dragon"));

    }
}


