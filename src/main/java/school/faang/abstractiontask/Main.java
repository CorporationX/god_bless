package school.faang.abstractiontask;

public class Main {
    public static void main(String[] args) {
        Character warriorFirst = new Warrior("Zombie");
        Character archerFirst = new Archer("Robin");

        warriorFirst.attack(archerFirst);
        System.out.println("Archer after warrior attack update: " + archerFirst);

        archerFirst.attack(warriorFirst);
        System.out.println("Warrior after archer attack update: " + warriorFirst);

    }
}
