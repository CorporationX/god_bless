package iplaybranch;

public class Main {

    public static void main(String[] args) {
        Character pasha = new Warrior( "Pasha");
        Character vasy = new Archer( "Vasy");

        System.out.println("Pasha health is: " + pasha.health);
        System.out.println("Vasy health is: " + vasy.health);
        System.out.println();

        pasha.attack(vasy);
        vasy.attack(pasha);

        System.out.println("Pasha health is: " + pasha.health);
        System.out.println("Vasy health is: " + vasy.health);
        System.out.println();
    }
}


