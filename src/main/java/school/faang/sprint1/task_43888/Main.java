package school.faang.sprint1.task_43888;

public class Main {
    public static void main(String[] args) {
        Warrior warrior1 = new Warrior("Org");
        Archer archer1 = new Archer("Human");

        warrior1.attack(archer1);
        archer1.attack(warrior1);
    }
}
