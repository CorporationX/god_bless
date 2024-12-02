package school.faang.task_43810;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Axe");
        Archer archer = new Archer("Hydra");
        warrior.attack(archer);
        archer.attack(warrior);

    }
}
