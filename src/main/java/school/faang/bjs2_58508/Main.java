package school.faang.bjs2_58508;

public class Main {

    public static void main(String[] args) {
        Warrior warrior = new Warrior("Konan");
        Archer archer = new Archer("Robin");

        System.out.println("Демонстрация боя между " + warrior.getName() + " и " + archer.getName() + ":");
        while (true) {
            warrior.attack(archer);
            if (archer.getHealth() <= 0) {
                return;
            }
            archer.attack(warrior);
            if (warrior.getHealth() <= 0) {
                return;
            }
        }
    }

}
