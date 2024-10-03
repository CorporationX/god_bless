package school.faang;

public class Main {
    public static void main(String[] args) {
        try {
            Character warrior = new Warrior("Cyklop");
            Character archer = new Archer("Taracan");
            for (int i = 0; i < 11; i++) {
                warrior.attack(archer);
                archer.attack(warrior);
            }

            System.out.println("Здоровье Warrior равно: " + warrior.getHitPoints());
            System.out.println("Здоровье Archer равно: " + archer.getHitPoints());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

