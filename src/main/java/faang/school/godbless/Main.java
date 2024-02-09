package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, House> housesMap = new HashMap<>();

        //добавление
        housesMap.put("Starks", new House("Winterfall", "Wolf"));
        housesMap.put("Lanister", new House("Casterly", "Lion"));
        housesMap.put("Barateon", new House("Dragon Stone", "Three-headed Dragon"));

        //удаление
        housesMap.remove("Starks");

        //get
        House getHouse = housesMap.get("Lanister");
        System.out.println("House name received:  " + getHouse);


        for (Map.Entry<String, House> entry : housesMap.entrySet()) {
            System.out.println("Name: " + entry.getKey() + "\t" + " Sigil: " + entry.getValue());
        }

    }
}

