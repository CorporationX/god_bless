package school.faang.BJS2_31288;

public class Main {

    public static void main(String[] args) {
        Warrior warrior = new Warrior("Арагорн");
        Archer archer = new Archer("Леголас");

        System.out.println(warrior);
        System.out.println(archer);

        warrior.attack(archer);
        System.out.println(archer);

        archer.attack(warrior);
        System.out.println(warrior);
    }
}
