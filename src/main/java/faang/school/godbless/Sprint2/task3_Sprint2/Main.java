package faang.school.godbless.Sprint2.task3_Sprint2;

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
