package school.faang.bjs2_85525;

import lombok.Getter;

@Getter
abstract class Character {
    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;

    private static final int BASE_HEALTH = 100;
    private int health = BASE_HEALTH;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.dexterity = 5;
        this.intelligence = 5;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    abstract void attack(Character opponent);

    void takeDamage(int amount) {
        if (amount < 0) {
            amount = 0;
        }
        health = health - amount;
        if (health < 0) {
            health = 0;
        }
    }

    public static void main(String[] args) {
        Warrior conan = new Warrior("Conan");
        Archer robin = new Archer("Robin");

        System.out.println("Начало боя. Здоровье Conan = " + BASE_HEALTH + ", Robin = " + BASE_HEALTH);

        conan.attack(robin);
        System.out.println("Здоровье Robin, после 1 удара Conan: " + robin.getHealth());

        robin.attack(conan);
        System.out.println("Здоровье Conan, после 1 удара Robin: " + conan.getHealth());
    }
}
