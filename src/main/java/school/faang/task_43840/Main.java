package school.faang.task_43840;

public class Main {
    public static void main(String[] args) {
        var warrior = new Warrior("John");
        var archer = new Archer("Lukas");

        System.out.println(warrior);
        System.out.println(archer);

        warrior.attack(archer);
        warrior.attack(null);
        archer.attack(warrior);

        System.out.println(warrior);
        System.out.println(archer);

        for (var i = 0; i < 100; i++) {
            archer.attack(warrior);
        }
        System.out.println(warrior);
    }
}
