package school.faang.sprint_1.abstraction;

public class Main {
    public static void main(String[] args) {

        school.faang.sprint_1.abstraction.Character warrior = new Warrior("Warrior");
        Character archer = new Archer("Archer");

        int i = 0;
        while (i < 11) {
            warrior.attack(archer);
            archer.attack(warrior);
            i++;
        }
    }
}