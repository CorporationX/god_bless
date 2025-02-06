package school.faang.bjs2_56385;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Horde");
        Character archer = new Archer("Alliance");

        System.out.println(warrior);
        System.out.println(archer);

        warrior.attack(archer);
        System.out.println(archer);

        archer.attack(warrior);
        System.out.println(warrior);

    }
}
