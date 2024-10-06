package school.faang.warrior;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Peter", 0, 0, 0);
        Archer archer = new Archer("John", 0, 0, 0);
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println(warrior.name + " is attacked you and you have  " + archer.health + " % left");
        System.out.println(archer.name + " is attacked you and you have  " + warrior.health + " % left");
    }
}

