package faang.school.godbless.done.character;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Dean");
        Character archer = new Archer("Sam");

        warrior.attack(archer);
        System.out.println(archer.getHealth());
        archer.attack(warrior);
        System.out.println(warrior.getHealth());
    }
}
