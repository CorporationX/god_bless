package school.faang.bjs2_68159;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Thorin");
        Character archer = new Archer("Legolas");


        System.out.println(archer);
        System.out.println(warrior);

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(archer);
        System.out.println(warrior);
    }
}
