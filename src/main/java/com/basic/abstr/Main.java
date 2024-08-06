package com.basic.abstr;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Axe");
        Character archer = new Archer("Ranger");

        warrior.attack(archer);
        System.out.println(archer.getHealth());

    }
}
