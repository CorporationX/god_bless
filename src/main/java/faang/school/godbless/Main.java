package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> houseMap = new HashMap<>();
    //Закомментировал из-за конфликта главного метода main с данным методом в application
    //public static void main(String... args) {
        House stark = new House("Stark", "direwolf");
        House lannister = new House("Lannister", "Lion rampant");
        House baratheon = new House("Baratheon", "black crowned stag");

    /*
    addition(stark.getName(),stark);

    addition(lannister.getName(),lannister);

    addition(baratheon.getName(),baratheon);

    delete(lannister.getName());

    search(baratheon.getName());

    listOfAllHouses();

    */
    }

    private static void addition(String name, House house) {
        houseMap.put(name, house);
    }

    public static void delete(String name) {
        houseMap.remove(name);
    }

    public static void search(String name) {
        System.out.println(houseMap.get(name).getSigil() + " Герб дома " + name);

    }

    public static void listOfAllHouses() {

        houseMap.forEach((name, house) -> System.out.println("Название дома: " + name + " Название герба: " + house.getSigil()));

    }
//}



