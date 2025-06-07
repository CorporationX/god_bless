package school.faang.bjs2_79245;

public class Main {
    public static void main(String[] args) {
        Character kaladin = new Warrior("Kaladin");
        Character legolas = new Archer("Legolas", 3, 8, 5);

        try {
            kaladin.attack(legolas);
            System.out.println(kaladin.getName() + ": " + kaladin.getHealthPoints());
            System.out.println(legolas.getName() + ": " + legolas.getHealthPoints());

            legolas.attack(kaladin);
            System.out.println(kaladin.getName() + ": " + kaladin.getHealthPoints());
            System.out.println(legolas.getName() + ": " + legolas.getHealthPoints());
        } catch (Exception e) {
            System.out.println("I have bad news for you, buddy...");
        }
    }
}
