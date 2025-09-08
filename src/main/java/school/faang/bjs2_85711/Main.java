package school.faang.bjs2_85711;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Richard");
        Archer archer = new Archer("Artur");

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println("\nHealth after attack: ");
        System.out.println(warrior.getName() + ": " + warrior.getHealth());
        System.out.println(archer.getName() + ": " + archer.getHealth());
    }
}