package Mathew;

import java.util.HashMap;

import static Mathew.Battlefield.battle;

public class Main {
    public static void main(String[] args) {
        Hero heroOne = new Hero("Роланд", "Ланцелот", 1000, 10, new HashMap<>());
        Hero heroTwo = new Hero("Кристофер", "Алый Лотос", 800, 8, new HashMap<>());

        Creature warrior = new Creature("Warrior", 1, 10, 5, 5, 100);
        Creature archer = new Creature("Archer", 1, 15, 3, 10, 50);

        heroOne.addCreature(warrior, 10);
        heroOne.addCreature(archer, 5);

        heroTwo.addCreature(warrior, 5);
        heroTwo.addCreature(archer, 10);

        Hero winner = battle(heroOne, heroTwo);
        System.out.println("Победитель " + winner.getName());
    }
}
