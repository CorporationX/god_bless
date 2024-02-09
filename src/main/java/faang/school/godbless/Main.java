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
        //
        //
        //  housesMap.remove("Starks");

        //get
        House getHouse = housesMap.get("Lanister");
        System.out.println("House name received:  " + getHouse);


        //когда удаляем Barateon house, проверка идет на дом Stark
//        if (housesMap.containsKey("Barateon")) {
//            System.out.println("Barateon house exist");
//        } else if (housesMap.containsKey("Starks")) {
//            System.out.println("Starks existed");
//        } else {
//            System.out.println("Lanisters");
//        }

        for (Map.Entry<String, House> entry : housesMap.entrySet()) {
            System.out.println("Name: " + entry.getKey() + "\t" + " Sigil: " + entry.getValue());
        }

    }
}

