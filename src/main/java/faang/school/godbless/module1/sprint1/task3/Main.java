package faang.school.godbless.module1.sprint1.task3;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("War");
        Character archer = new Archer("Bow");
        archer.attack(warrior);
        warrior.attack(archer);
    }

}
