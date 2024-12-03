package school.faang.task_43807;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Warrior");
        Archer archer = new Archer("Archer");
        System.out.println("Warrior " + warrior);
        System.out.println("Archer " + archer);
        warrior.attack(archer);
        System.out.println("Warrior " + warrior);
        System.out.println("Archer " + archer);
        archer.attack(warrior);
        System.out.println("Warrior " + warrior);
        System.out.println("Archer " + archer);
    }
}
