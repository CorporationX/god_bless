package school.faang.witcher;

import java.util.*;
import java.util.stream.*;

public class WitcherWorldGenerator {
    private static final List<String> CITY_NAMES = List.of(
            "Novigrad", "Oxenfurt", "Vizima", "Kaer Morhen", "Beauclair",
            "Toussaint", "Gors Velen", "Cintra", "Rivia", "Nilfgaard"
    );

    private static final List<String> MONSTER_NAMES = List.of(
            "Leshen", "Drowner", "Katakan", "Striga", "Griffin", "Fiend",
            "Botchling", "Noonwraith", "Ekhidna", "Hym", "Alp", "Bruxa",
            "Basilisk", "Chort", "Foglet", "Gargoyle", "Harpy", "Mucknixer",
            "Nightwraith", "Wraith", "Werewolf", "Wyvern", "Ghoul", "Ekimmara",
            "Golem", "Forktail", "Cyclops", "Ice Elemental", "Fire Elemental", "Earth Elemental",
            "Siren", "Water Hag", "Plague Maiden", "Devourer", "Cursed Knight", "Fiery Phantom",
            "Barghest", "Phantom Warrior", "Ancient Leshen", "Phantom of the Keep"
    );

    private static final Random random = new Random();

    public static List<City> generateCities(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> {
                    String name = CITY_NAMES.get(i % CITY_NAMES.size());
                    Location loc = randomLocation();
                    return new City(name, loc);
                })
                .collect(Collectors.toList());
    }

    public static List<Monster> generateMonsters(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> {
                    String name = MONSTER_NAMES.get(random.nextInt(MONSTER_NAMES.size()));
                    Location loc = randomLocation();
                    return new Monster(name, loc);
                })
                .collect(Collectors.toList());
    }

    private static Location randomLocation() {
        int x = random.nextInt(100, 1000); // от 0 до 999
        int y = random.nextInt(100, 1000);
        return new Location(x, y);
    }
}
