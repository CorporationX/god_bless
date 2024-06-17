package BJS2_8005;

import java.util.HashMap;
import java.util.Map;

public class House {

    String name;
    String sigil;
    public static HashMap<String, House> gameOfThrones = new HashMap<>();
    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }
    public String getName() {
        return name;
    }
    public String getSigil() {
        return sigil;
    }

    @Override
    public String toString() {
        return getSigil();
    }

    public static void removeByName(String name) {
        if (gameOfThrones.containsKey(name)) {
            gameOfThrones.remove(name);
            System.out.println("Дом " + name + " удален из списка");
        } else {
            System.out.println("Дома " + name + " нет в списке");
        }
    }
    public static void addHouse(House house) {
        gameOfThrones.put(house.getName(), house);
    }
    public static void sigilInfo(String name) {
        if (gameOfThrones.containsKey(name)) {
            System.out.println("Герб дома " + name + " :" + gameOfThrones.get(name));
        } else {
            System.out.println("Дома " + name + " нет в списке");
        }
    }
    public static void allHouses(){
        System.out.println(gameOfThrones);
}
}
