package task_BJS2_56366;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Anton");
        System.out.println(archer);

        Warrior warrior = new Warrior("Bob");
        System.out.println(warrior);

        archer.attack(warrior);
        System.out.println(warrior);

        warrior.attack(archer);
        System.out.println(archer);

    }
}
