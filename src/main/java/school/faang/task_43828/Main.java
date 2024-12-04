package school.faang.task_43828;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Earthshaker");
        Archer archer = new Archer("Faceless Void");

        warrior.attack(archer);
        archer.attack(warrior);

        warrior.attack(archer);
        archer.attack(warrior);
    }
}
