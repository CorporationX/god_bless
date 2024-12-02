package school.faang.bjs2_43821;

public class Main {

    public static void main(String[] args) {

        Warrior warrior = new Warrior("Sam");
        Archer archer = new Archer("Tim");
        warrior.attack(archer);
        archer.attack(warrior);
        warrior.attack(archer);
        System.out.println(warrior.getName() + " health = " + warrior.getHealth());
        System.out.println(archer.getName() + " health = " + archer.getHealth());

    }
}
