package BJS2_8005;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, House> gameOfThrones = new HashMap<>();
        House house01 = new House("Stark", "Wolf");
        House house02 = new House("Lannister", "Lion");
        House house03 = new House("Baratheon", "Deer");
        gameOfThrones.put(house01.getName(), house01);
        gameOfThrones.put(house02.getName(), house02);
        gameOfThrones.put(house03.getName(), house03);
        System.out.println(gameOfThrones);
        gameOfThrones.remove(house01.getName());
        if (gameOfThrones.containsKey(house01.getName())) {
            System.out.println(gameOfThrones.get(house01.getName()).getSigil());
        } else {
            System.out.println("Дома нет в списке");
        }
        System.out.println(gameOfThrones);
    }
}



