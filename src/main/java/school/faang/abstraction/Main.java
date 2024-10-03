package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        Character warriorPetya = new Warrior("Petya");
        Character archerVasya = new Archer("Vasya");

        warriorPetya.attack(archerVasya);
        archerVasya.attack(warriorPetya);
    }
}
