package school.faang.bjs2_79160;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Ronan");
        Archer archer = new Archer("Robin Hood");

        System.out.println(archer.getHealth());
        warrior.attack(archer);
        System.out.println(archer.getHealth());

        for (int i = 0; i < 10; i++) {
            warrior.attack(archer);
        }
        System.out.println(archer.getHealth());
    }

}
