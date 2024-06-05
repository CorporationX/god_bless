package faang.school.godbless.JavaBeisic_BJS2_7740;

import lombok.Data;


public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Войн");
        Archer archer = new Archer("Лучник");

        System.out.println(warrior.getName() + " имеет здоровье " + warrior.getHealth());
        System.out.println(archer.getName() + " имеет здоровье " + archer.getHealth());

        warrior.attack(archer);
        System.out.println(archer.getName() + " теперь имеет здоровье " + archer.getHealth());
        warrior.attack(archer);
        System.out.println(archer.getName() + " теперь имеет здоровье " + archer.getHealth());

        archer.attack(warrior);
        System.out.println(warrior.getName() + " теперь имеет здоровье " + warrior.getHealth());
        archer.attack(warrior);
        System.out.println(warrior.getName() + " теперь имеет здоровье " + warrior.getHealth());
    }

}
