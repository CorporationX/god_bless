package faang.school.godbless.javaCore.abstractAbstract;

public class Main {
    public static void main(String[] args) {
        Character archer = new Archer("Archer", 3, 10, 5);
        Character warrior = new Warrior("Warrior", 10, 5, 3);

        archer.attack(warrior);

        System.out.println(warrior.getHealth());

        warrior.attack(archer);
        warrior.attack(archer);

        System.out.println(archer.getHealth());
    }
}
