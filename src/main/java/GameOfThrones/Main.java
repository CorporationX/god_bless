package GameOfThrones;

import java.util.HashMap;

public class Main {

    private static final HashMap<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        addHouse("Stark", "Wolf");
        addHouse("Lannister", "Lion");
        addHouse("Baratheon", "Stag");
        addHouse("Targaryen", "Dragon");
        printInfoAboutAllHouses();
        deleteHouseByName("Stark");
        printInfoAboutHouseByName("Stark");

    }

    public static House addHouse(String name, String sigil){
        House house = new House(name, sigil);
        houses.put(name, house);
        return house;
    }

    public static House deleteHouseByName(String name){
        return houses.remove(name);
    }

    public static House getHouseByName(String name){
        return houses.get(name);
    }

    public static void printInfoAboutHouseByName(String name){
        House house = getHouseByName(name);
        if (house == null){
            System.out.printf("Информация о доме %s не была найдена%n", name);
        }else{
            System.out.printf("Герб дома %s - %s%n", house.getName(), house.getSigil());
        }
    }

    public static void printInfoAboutAllHouses(){
        for (House house : houses.values()){
            System.out.printf("Герб дома %s - %s%n", house.getName(), house.getSigil());
        }
    }

}
