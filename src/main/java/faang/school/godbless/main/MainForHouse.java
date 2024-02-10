package faang.school.godbless.main;


import java.util.HashMap;
import java.util.Map;

public class MainForHouse {
    static Map<String, House> houses = new HashMap<>();
    public static void main(String... args) {
        House stark = new House("Stark", "a grey direwolf racing across a field of white");
        House lannister = new House("Lannister", " a golden lion on a field of crimson");
        House barateon = new House("Barateon", "a crowned black stag on a golden field");
        House targaryen = new House("Targaryen", "a red three-headed dragon, breathing red flames on black");
        House tarly = new House("Tarly", "the striding huntsman on green");
        add(stark);
        add(lannister);
        add(barateon);
        add(targaryen);
        add(tarly);
        getAllHouses();
        delete(targaryen.getName());
        getAllHouses();
        searchForHouse("Barateon");
    }

    public static void add(House house) {
        houses.put(house.getName(), house);
    }

    public static void delete(String name) {
        houses.remove(name);
    }

    public static void searchForHouse(String name) {
        if (houses.containsKey(name)) {
            System.out.println(name + "'s sigil is " + houses.get(name).getSigil() + ".");
        }
    }

    public static void getAllHouses() {
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            System.out.println(entry.getKey() + "'s sigil is " + entry.getValue().getSigil() + ".");
        }
    }
}
