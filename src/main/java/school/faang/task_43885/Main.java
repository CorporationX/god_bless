package school.faang.task_43885;

public class Main {
    public static void main(String[] args) {

        Warrior warrior = new Warrior("Bob", 0, 0, 0);
        Archer archer = new Archer("Ben", 0, 0, 0);

        archer.attack(warrior);
        archer.getLevelAlive();

        warrior.checkHealth();
        warrior.attack(archer);
        warrior.getLevelAlive();
    }
}
