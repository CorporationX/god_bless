package faang.school.godbless.task3;

public class TestCharacter {

    public static void main(String[] args) {
        Warrior warrior = new Warrior(1,1,1);
        warrior.name="Oleg";

        Archer archer = new Archer(1,1,1);
        archer.name = "Alen";

        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println(warrior );
        System.out.println(archer);

    }
}
