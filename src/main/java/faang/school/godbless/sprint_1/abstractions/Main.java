package faang.school.godbless.sprint_1.abstractions;

public class Main {

    public static void main(String[] args) {

        Character warrior = new Warrior("Warrior");
        Character archer = new Archer("Archer");

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(warrior);
        System.out.println(archer);
    }

}
