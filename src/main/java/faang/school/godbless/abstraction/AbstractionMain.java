package faang.school.godbless.abstraction;

public class AbstractionMain {

    public static void main(String[] args) {
        Character archer = new Archer("Windranger", 4, 12, 4);
        Character warrior = new Warrior("Axe");
        archer.attack(warrior);
        warrior.attack(archer);
        System.out.println(archer);
        System.out.println(warrior);
    }
}
