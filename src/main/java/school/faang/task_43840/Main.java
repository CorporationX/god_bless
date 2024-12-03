package school.faang.task_43840;

public class Main {
    public static void main(String[] args) {
        var warrior = new Warrior("John");
        var archer = new Archer("Lukas");

        System.out.println(warrior);
        System.out.println(archer);

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(warrior);
        System.out.println(archer);
    }
}
