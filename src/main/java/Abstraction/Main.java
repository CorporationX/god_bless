package Abstraction;

public class Main {
    public static void main(String[] args) {

        Warrior warriorBen = new Warrior("Ben");
        Archer archerTen = new Archer("Ten");
        warriorBen.attack(archerTen);
        archerTen.attack(warriorBen);
        System.out.println(warriorBen.name + " - " + warriorBen.health + " : " + archerTen.health + " - " + archerTen.name);

    }

}
