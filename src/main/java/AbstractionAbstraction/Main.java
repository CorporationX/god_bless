package AbstractionAbstraction;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Bob");
        Character archer = new Archer("Rob");

        archer.attack(warrior);
        System.out.println("Warrior health = " + warrior.getHealth());

        warrior.attack(archer);
        System.out.println("Archer health = " + archer.getHealth());
    }
}
