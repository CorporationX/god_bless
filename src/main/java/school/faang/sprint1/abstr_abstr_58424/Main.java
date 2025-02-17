package school.faang.sprint1.abstr_abstr_58424;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Tigreal");
        Character archer = new Archer("Irithel");

        System.out.println(warrior);
        System.out.println(archer);

        warrior.attack(archer);
        System.out.println(archer);

        archer.attack(warrior);
        archer.attack(warrior);
        System.out.println(warrior);
        archer.attack(warrior);
        System.out.println(warrior);
    }
}
