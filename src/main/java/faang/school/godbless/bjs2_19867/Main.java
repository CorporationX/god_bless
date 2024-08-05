package faang.school.godbless.bjs2_19867;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        var houses = new HashMap<String, House>();

        var stark = House.builder().name("Stark").sigil("Stark sigil").build();
        var lannister = House.builder().name("Lannister").sigil("Lannister sigil").build();
        var barateon = House.builder().name("Barateon").sigil("Barateon sigil").build();
        var null1 = House.builder().name(null).sigil(null).build();
        var null2 = House.builder().name(null).sigil("not null").build();
        var null3 = House.builder().name("not null").sigil(null).build();
        var duplicate1 = House.builder().name("duplicate").sigil("duplicate").build();
        var duplicate2 = House.builder().name("duplicate").sigil("duplicate").build();

        houses.put(stark.getName(), stark);
        houses.put(lannister.getName(), lannister);
        houses.put(barateon.getName(), barateon);
        houses.put(null1.getName(), null1);
        houses.put(null2.getName(), null2);
        houses.put(null3.getName(), null3);
        houses.put(duplicate1.getName(), duplicate1);
        houses.put(duplicate2.getName(), duplicate2);
        System.out.println("Size of houses: " + houses.size());

        houses.remove(barateon.getName());
        System.out.println("Size of map: " + houses.size());

        var foundLannister = houses.get(lannister.getName());
        System.out.println("Lannister's sigil: " + foundLannister.getSigil());

        System.out.println();
        for (Map.Entry<String, House> house : houses.entrySet()) {
            System.out.println("Key: " + house.getKey() + "; House: " + house.getValue().toString());
        }
    }
}
