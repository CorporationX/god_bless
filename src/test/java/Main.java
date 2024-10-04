

public class Main {

    public static void main(String[] args) {
        Character Pasha = new Warrior(10, 18, 33, "Pasha");
        Character Vasy = new Archer(11, 20, 33, "Vasy");

        System.out.println("Pasha health is: " + Pasha.health);
        System.out.println("Vasy health is: " + Vasy.health);
        System.out.println();

        Pasha.attack(Vasy);
        Vasy.attack(Pasha);

        System.out.println("Pasha health is: " + Pasha.health);
        System.out.println("Vasy health is: " + Vasy.health);
        System.out.println();
    }
}


