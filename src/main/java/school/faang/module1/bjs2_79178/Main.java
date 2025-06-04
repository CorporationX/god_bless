package school.faang.module1.bjs2_79178;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {

        Character warrior = new Warrior("Warrior");
        Character archer = new Archer("Archer");

        log.info("{} начальное здоровье: {}", warrior.getName(), warrior.getHealth());
        log.info("{} начальное здоровье: {}", archer.getName(), archer.getHealth());

        warrior.attack(archer);
        log.info("{} здоровье после атаки: {}", archer.getName(), archer.getHealth());

        archer.attack(warrior);
        log.info("{} здоровье после атаки: {}", warrior.getName(), warrior.getHealth());
    }
}
