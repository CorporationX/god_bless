package school.faang.bsj2_86668;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Warrior");
        Character archer = new Archer("Archer");
        System.out.println("Warrior = " + warrior);
        System.out.println("Archer = " + archer);
        for (int i = 0; i < 10; i++) {
            try {
                warrior.attack(archer);
                System.out.println("Warrior after attack = " + warrior);
                System.out.println("Archer after attack = " + archer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 10; i++) {
            archer.attack(warrior);
            System.out.println("Warrior after attack = " + warrior);
            System.out.println("Archer after attack = " + archer);
        }
    }
}
