package school.faang.sprint1.bjs_43880;

public class Main {
    public static void main(String[] args) {
        Character warrior1 = new Warrior("Thor");
        printStatistics(warrior1);

        Character warrior2 = new Warrior(15, 10, 25);
        printStatistics(warrior2);

        Character archer1 = new Archer("Howkeye");
        printStatistics(archer1);

        Character archer2 = new Archer(15, 10, 30);
        printStatistics(archer2);

        warrior1.attack(archer1);
        printStatistics(archer1);

        archer1.attack(warrior1);
        printStatistics(warrior1);
    }

    private static void printStatistics(Character character) {
        System.out.println("Имя: " + character.name);
        System.out.println("Здоровье: " + character.health);
        System.out.println("Сила: " + character.force);
        System.out.println("Ловкость: " + character.dexterity);
        System.out.println("Интеллект: " + character.intelligence + "\n");
    }
}
