package faang.school.godbless;

import java.util.Map;

public class House {
    private String name, sigil;

    public String getName() {
        return name;
    }

    public String getSigil() {
        return sigil;
    }

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", sigil='" + sigil + '\'' +
                '}';
    }

    public static void addHouse(Map<String, House> map, House house) {
        map.put(house.getName(), house);
    }

    public static void delHouse(Map<String, House> map, String name) {
        map.remove(name);
    }

    public static void getHouse(Map<String, House> map, String name) {
        System.out.println(map.get(name));
    }

    public static void getAllHouses(Map<String, House> map) {
        for (Map.Entry<String, House> pair : map.entrySet()) {
            String name = pair.getKey();
            String house = " Название дома: " + pair.getValue().getName() + ", Герб: " + pair.getValue().getSigil();
            System.out.println(name + house);
        }
    }
}
