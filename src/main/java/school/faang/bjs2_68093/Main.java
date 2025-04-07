package school.faang.bjs2_68093;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Character archer = new Archer("Комиссар Горгонитов");
        Character warrior = new Warrior("Зельда");
        Character strongWarrior = new Warrior("Супермен", 110, 100, 1);
        log.info("Здоровье warrior: {}", warrior.health);
        log.info("Ловкость archer: {}", archer.agility);
        archer.attack(warrior);
        log.info("Здоровье warrior после атаки archer: {}", warrior.health);
        log.info("Сила strongWarrior: {}", strongWarrior.strength);
        log.info("Здоровье archer: {}", archer.health);
        strongWarrior.attack(archer);
        log.info("Здоровье archer после атаки strongWarrior: {}", archer.health);
    }
}
