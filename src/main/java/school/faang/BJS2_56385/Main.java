package school.faang.BJS2_56385;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Horde");
        Archer archer = new Archer("Alliance");

        System.out.println(warrior);
        System.out.println(archer);

        warrior.attack(archer);
        System.out.println(archer);

        archer.attack(warrior);
        System.out.println(warrior);

    }
}
