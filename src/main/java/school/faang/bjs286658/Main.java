package school.faang.bjs286658;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Black");
        Character archer = new Warrior("White");


        System.out.println(warrior);
        System.out.println(archer);

        warrior.attack(archer);
        System.out.println(archer);

        archer.attack(warrior);
        System.out.println(warrior);

        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        System.out.println(warrior);
    }
}
