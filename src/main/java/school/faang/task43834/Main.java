package school.faang.task43834;

public class Main {
    public static void main(String[] args) {
        Character character1 = new Warrior("Orc");
        Character character2 = new Archer("Elf");
        battle(character1, character2);
        printHealthOfWarrior(character1, character2);
    }

    public static void battle(Character warrior, Character archer) {
        warrior.attack(archer);
        archer.attack(warrior);

    }

    public static void printHealthOfWarrior(Character warrior1, Character warrior2) {
        System.out.println("health of " + warrior1.name + " = " + warrior1.health);
        System.out.println("health of " + warrior2.name + " = " + warrior2.health);
    }
}
