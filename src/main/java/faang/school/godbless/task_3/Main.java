package faang.school.godbless.task_3;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Voin");
        Archer archer = new Archer("Luchnik");
        warrior.attack(archer);
        archer.attack(warrior);
    }
}
