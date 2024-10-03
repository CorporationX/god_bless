package school.faang;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Cyklop");
        Character archer = new Archer("Taracan");
        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println("Здоровье Warrior равно: " + warrior.getHitPoints());
        System.out.println("Здоровье Archer равно: " + archer.getHitPoints());
    }
}

