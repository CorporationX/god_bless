package school.faang.bjs2_79362;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Dark");
        Character archer = new Archer("Net");

        warrior.attack(archer);
        log.info(archer.getName() + " здоровье " + archer.getHealth());

        archer.attack(warrior);
        log.info(warrior.getName() + " здоровье " + warrior.getHealth());
    }
}




