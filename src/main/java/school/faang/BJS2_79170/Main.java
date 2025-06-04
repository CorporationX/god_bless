package school.faang.BJS2_79170;

public class Main {
    public static void main(String[] args) {
        Character archer = new Archer("Guns");
        Character warrior = new Warrior("Bursik");

        while (archer.getHealth() != 0 && warrior.getHealth() != 0) {
            System.out.println("Здрововье Ганса: " + archer.getHealth());
            System.out.println("Здрововье Барсика: " + warrior.getHealth());
            archer.attack(warrior);
        }
    }
}
