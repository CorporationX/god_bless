package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public record House(String name, String sigil) {
    static Map<String, House> map = new HashMap<>();

    public static void main(String[] args) {

        map.put("Stark", new House("Ned", "Волк"));
        map.put("Lanister", new House("Tirion", "Лев"));
        map.put("Baration", new House("Robert", "Олень"));

        House oneHouse = new House("Дейенерис ", "Дракон");
        add("Targarien", oneHouse);
        remove("Stark");
        System.out.println(get("Baration"));
        printALL();


    }

    public static void add(String name, House house) {
        map.put(name, house);
    }

    public static void remove(String name) {
        map.remove(name);
    }

    public static String get(String name) {
        return map.get(name).sigil();
    }

    public static void printALL() {
        map.forEach((key, house) -> System.out.println(key + ":" + house.sigil()));
    }
}
