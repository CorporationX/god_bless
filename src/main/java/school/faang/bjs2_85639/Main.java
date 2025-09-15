package school.faang.bjs2_85639;


public class Main {
    public static void main(String[] args) {
        Character archer = new Archer("Drow Ranger");
        Character warrior = new Warrior("Axe");

        warrior.attack(archer);
        System.out.println(archer.getHealth());

        for (int i = 0; i < 10; i++) {
            archer.attack(warrior);
        }

        System.out.println(warrior.getHealth());


    }

}
