package faang.school.godbless.task_3;

public class Main {
    public static void main(String[] args) {
        var warrior = new Warrior("Andrei");
        var archer = new Archer("Bob");
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println("Warrior health: " + warrior.getHealth());
        System.out.println("Archer health: " + archer.getHealth());
    }
}
