package school.faang;

public class Main {
    public static void main(String[] args) {
        Character warriorFirst = new Warrior(10, 5, 3);
        warriorFirst.setName("Zombie");

        Character archerFirst = new Archer(3, 10, 5);
        archerFirst.setName("Robin");

        warriorFirst.attack(archerFirst);
        System.out.println("Archer after warrior attack update: " + archerFirst.getString() );

        archerFirst.attack(warriorFirst);
        System.out.println("Warrior after archer attack update: " + warriorFirst.getString() );

    }
}
