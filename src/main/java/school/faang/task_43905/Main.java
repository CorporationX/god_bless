package school.faang.task_43905;

public class Main {
    public static void main(String[] args) {
        Character customArcher = new Archer("Luna");
        Character customWarrior = new Warrior("Beast");

        customArcher.attack(customWarrior);
        customWarrior.attack(customArcher);
    }
}
