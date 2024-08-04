package faang.school.javacore.abstraction;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer();
        Warrior warrior = new Warrior();

        System.out.println(archer.attack(warrior));
        System.out.println(warrior.health);

    }
}
