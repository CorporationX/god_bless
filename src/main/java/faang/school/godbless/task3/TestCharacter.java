package faang.school.godbless.task3;

public class TestCharacter {

    public static void main(String[] args) {
        Warrior warrior = new Warrior("Oleg");

        Archer archer = new Archer("Alen");

        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println(warrior );
        System.out.println(archer);

    }
}
