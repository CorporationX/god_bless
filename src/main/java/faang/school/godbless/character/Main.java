package faang.school.godbless.character;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Dean");
        Archer archer = new Archer("Sam");

        warrior.attack(archer);
        System.out.println(archer.getHealth());
        archer.attack(warrior);
        System.out.println(warrior.getHealth());
    }
}
