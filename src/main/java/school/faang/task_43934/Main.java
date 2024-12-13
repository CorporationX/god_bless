package school.faang.task_43934;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Arch");
        Warrior warrior = new Warrior("War");

        archer.attack(warrior);
        System.out.println(warrior.health);
    }
}
