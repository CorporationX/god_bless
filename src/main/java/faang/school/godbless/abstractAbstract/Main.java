package faang.school.godbless.abstractAbstract;

public class Main {
    public static void main(String[] args) {
        Character archer = new Archer("Archer");
        Character warrior = new Warrior("Warrior");

        archer.attack(warrior);
        System.out.println(warrior.getHealth());

        warrior.attack(archer);
        warrior.attack(archer);
        System.out.println(archer.getHealth());
    }
}
