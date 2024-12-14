package faang.school.godbless.sprint_1.task_43932;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warrior");
        Archer archer = new Archer("Archer");

        while (warrior.getHealth() != 0 && archer.getHealth() != 0) {
            if (warrior.getHealth() != 0) {
                warrior.attack(archer);
            }
            if (archer.getHealth() != 0) {
                archer.attack(warrior);
            }
        }
    }
}
