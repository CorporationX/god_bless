package ru.kraiush.BJS2_31276;

public class Main {

    public static void main(String[] args) {

        Character warrior = new Warrior("Titan");
        Character archer = new Archer("Legolas");

        warrior.attack(archer);
        System.out.println("After the first fight:\n" +
                "Warrior: " + warrior + "\n" +
                "Archer: " + archer);

        archer.attack(warrior);
        System.out.println("After the second fight:\n" +
                "Warrior: " + warrior + "\n" +
                "Archer: " + archer);
    }
}
