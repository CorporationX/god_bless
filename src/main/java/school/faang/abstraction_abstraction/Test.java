package school.faang.abstraction_abstraction;

public class Test {
    public static void main(String[] args) {
        Character alexey = new Warrior("Alexey");
        Character buba = new Archer("Buba");

        while (buba.getHealth() > 0 && alexey.getHealth() > 0) {
            if (alexey.getHealth() > 0) {
                alexey.attack(buba);
                System.out.printf("Alexey attack Buba, this hit make %d damage -- Buba's health is %d\n",
                        alexey.getStrength(), buba.getHealth());
            }
            if (buba.getHealth() > 0) {
                buba.attack(alexey);
                System.out.printf("Buba attack Alexey, this hit make %d damage -- Alexey's health is %d\n",
                        buba.getAgility(), alexey.getHealth());
            }
            if (alexey.getHealth() == 0) {
                System.out.println("Alexey is dead, Buba wins");
            }
            if (buba.getHealth() == 0) {
                System.out.println("Buba is dead, Alexey wins");
            }
        }
    }
}