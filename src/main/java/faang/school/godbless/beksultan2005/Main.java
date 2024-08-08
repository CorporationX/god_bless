package faang.school.godbless.beksultan2005;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, House> houses = new HashMap<>();

    public static void addHouse(House house) {
        houses.put(house.getName(), house);
    }

    public static void deleteHouse(String name) {
        houses.remove(name);
    }

    public static String getSigil(String name) {
        return houses.get(name).getSigil();
    }

    public static void getAllHouse() {
        houses.forEach((key, value) -> System.out.println(key + ": " + value.getSigil()));
    }

    public static void main(String[] args) {

        addHouse(new House("Stark", "Direwolf"));
        addHouse(new House("Lannister", "Lion"));
        addHouse(new House("Baratheon", "Stag"));
        addHouse(new House("Targaryen", "Dragon"));
        addHouse(new House("Greyjoy", "Kraken"));

        deleteHouse("Baratheon");

        System.out.println(getSigil("Stark"));

        getAllHouse();

        Hero hero1 = new Hero("Arthur", 3, 1);
        Hero hero2 = new Hero("Morgana", 4, 2);

        Creature pikeman = new Pikeman();
        Creature griffin = new Griffin();
        Creature swordman = new Swordman();
        Creature angel = new Angel();

        hero1.addCreature(pikeman, 10);
        hero1.addCreature(griffin, 5);
        hero1.addCreature(swordman, 7);
        hero1.addCreature(angel, 12);

        hero2.addCreature(pikeman, 15);
        hero2.addCreature(griffin, 4);
        hero2.addCreature(swordman, 6);
        hero2.addCreature(angel, 3);

        hero1.removeCreature(angel, 1);

        hero1.getArmy();
        hero2.getArmy();

        Battlefield battlefield = new Battlefield(hero1, hero2);
        battlefield.battle();
    }
}

