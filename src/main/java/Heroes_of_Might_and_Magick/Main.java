package Heroes_of_Might_and_Magick;

import java.util.HashMap;

import static Heroes_of_Might_and_Magick.Battlefield.battle;

public class Main {
    public static void main(String[] args) {
        Hero heroOne = new Hero("Роланд", "Ланцелот", 1000, 10, new HashMap<>());
        Hero heroTwo = new Hero("Кристофер", "Алый Лотос", 800, 8, new HashMap<>());

        Creature warrior = new Swordsman("Warrior", 1, 10, 5, 5, 100);
        Creature warrior2 = new Angel("Christin", 10, 30, 10, 10, 1);

        heroOne.addCreature(warrior, 10);
        heroOne.addCreature(warrior2, 5);
        heroTwo.addCreature(warrior, 5);
        heroTwo.addCreature(warrior2, 10);
        Hero winner = battle(heroOne, heroTwo);
        System.out.println("Победитель " + winner.getName());
    }
}
