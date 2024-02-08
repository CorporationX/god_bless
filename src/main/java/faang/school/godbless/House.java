package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class House {
    private String name;
    private String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    public String getSigil() {
        return sigil;
    }

    public String toString(){
        return name + " " + sigil;
    }

    public static void main(String args[]){
        HashMap<String, House> housesMap = new HashMap<>();

        addHouse(housesMap, "Stark", "Direwolf");
        addHouse(housesMap, "Lannister", "Lion");
        addHouse(housesMap, "Baratheon", "Stag");

        printAllHouses(housesMap);

        searchAndPrintHouse(housesMap, "Stark");

        removeHouse(housesMap, "Lannister");

        printAllHouses(housesMap);
    }

    private static void addHouse(Map<String, House> housesMap, String name, String sigil){
        House house = new House(name, sigil);
        housesMap.put(name, house);
    }

    private static void printAllHouses(Map<String, House> housesMap){
        for(Map.Entry<String, House> entry : housesMap.entrySet()){
            System.out.println("House: " + entry.getKey() + ", Sigil: " + entry.getValue());
        }
    }

    private static void searchAndPrintHouse(Map<String, House> housesMap, String name){
        if(housesMap.containsKey(name)){
            House house = housesMap.get(name);
            System.out.println(name + " - Found!" + " Sigil: " + house.getSigil());
        } else System.out.println(name + " - Not found.");
    }

    private static void removeHouse(Map<String, House> housesMap, String name){
        if(housesMap.containsKey(name)){
            housesMap.remove(name);
            System.out.println(name + " - Deleted.");
        } else System.out.println(name + " - Not found.");
    }


}
