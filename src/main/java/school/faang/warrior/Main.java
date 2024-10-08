package school.faang.warrior;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Peter");
        Archer archer = new Archer("John");
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println(warrior.name + " is attacked you and " + archer.health + " % left");
        System.out.println(archer.name + " is attacked you and you have  " + warrior.health + " % left");
    }
}

