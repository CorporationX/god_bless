package faang.school.godbless.gameofthrones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public HashMap<String, House> housesOfWesteros;

    public Main() {
        housesOfWesteros = new HashMap<>();

        housesOfWesteros.put("Дом Бронна", new House( "Дом Бронна", "Стрела"));
        housesOfWesteros.put("Аррены", new House("Аррены", "Орёл"));
        housesOfWesteros.put("Баратеоны", new House("Баратеоны", "Олень"));
        housesOfWesteros.put("Грейджои", new House("Грейджои", "Ктулху"));
        housesOfWesteros.put("Ланнистеры", new House("Ланнистеры", "Лев"));
        housesOfWesteros.put("Мартеллы", new House("Мартеллы", "Копьё"));
        housesOfWesteros.put("Старки", new House("Старки", "Волк"));
        housesOfWesteros.put("Талли", new House("Талли","Рыба"));
    }

    public void addHouse(String name, House house) {
        housesOfWesteros.put(name, house);
    }

    public void delHouse(String name) {
        housesOfWesteros.remove(name);
    }

    public String getSigil(String name) {
        return housesOfWesteros.get(name).getSigil();
    }

    public List<String> getHouseNamesAndSigils() {
        List<String> result = new ArrayList<>();

        for (House house : housesOfWesteros.values()) {
            result.add("name: " + house.getName() + ", " + "sigil: " + house.getSigil());
        }

        return result;
    }

}
