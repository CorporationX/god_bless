package school.faang.bjs2_79240;

public class Main {
    public static void main(String[] args) {
        Character megaWarrior = new Warrior("MegaWarrior", 10, 10, 10);
        System.out.println(megaWarrior);
        Character megaArcher = new Archer("MegaArcher", 10, 10, 10);
        System.out.println(megaArcher);

        Character warrior = new Warrior("Warrior");
        Character archer = new Archer("Archer");
        System.out.println(warrior);
        System.out.println(archer);

        warrior.attack(archer);
        System.out.println(archer.getHealth());

        archer.attack(warrior);
        System.out.println(warrior.getHealth());

        for  (int i = 0; i < 10; i++) {
            archer.attack(warrior);
            System.out.println(warrior.getHealth());
        }
    }
}
