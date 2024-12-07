package ru.task_43860;

public class Main {
    public static void main(String[] args) {
        Warrior knight = new Warrior("Bob");
        Archer samurai = new Archer("John");

        knight.attack(samurai);
        System.out.println(samurai.getStrength());
        System.out.println(samurai.getHealth());
        System.out.println(knight.getStrength());
        System.out.println(knight.getHealth());
    }

}
