package faang.school.godbless.task3;

public class Main {
    public static void main(String[] args) {
        Character archer = new Archer("Archer");
        Character warrior = new Warrior("Warrior");
        archer.attack(warrior);
        for (int i = 0; i < 10; i++) {
            warrior.attack(archer);
        }
    }


}
