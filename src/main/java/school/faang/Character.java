package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
abstract class Character {
    public String name;
    public int strength;
    public int agility;
    public int intelligence;
    public int health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent) throws Exception;

    public static void main(String[] args) throws Exception {
        Archer archer = new Archer("Ron");
        Warrior warrior = new Warrior("Hamlet");
        Random random = new Random();
        int randomArcher = random.nextInt(20);
        int randomWarrior = random.nextInt(20);
        for (int i = 0; i < randomArcher; i++) {
            archer.attack(warrior);
            log.info(archer.getName() + " deals 10 damage. " + warrior.getName()
                    + "'s health: " + warrior.getHealth());
            if (warrior.getHealth() <= 0) {
                log.info(archer.getName() + " wins! " + warrior.getName() + " is dead!");
                break;
            }
        }

        for (int i = 0; i < randomWarrior; i++) {
            warrior.attack(archer);
            log.info(warrior.getName() + " deals 10 damage. " + archer.getName()
                    + "'s health: " + archer.getHealth());
            if (archer.getHealth() <= 0) {
                log.info(warrior.getName() + " wins! " + archer.getName() + " is dead!");
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getHealth() {
        return health;
    }
}
