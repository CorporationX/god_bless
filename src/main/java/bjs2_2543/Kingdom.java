package bjs2_2543;

import java.util.HashMap;
import java.util.Map;

public class Kingdom {
    private Map<String, House> houses = new HashMap<>();

    public void add(String name, String sigil) {
        houses.put(name, new House(name, sigil));
    }

    public void delete(String name) {
        houses.remove(name);
    }

    public void getAll() {
        houses.values().forEach(v -> System.out.println(v.getName() + " - " + v.getSigil()));
    }

    public void getSigil(String name) {
        String sigil = houses.get(name).getSigil();
        System.out.println(sigil);
    }
}
