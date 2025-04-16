package school.faang.abstraction_abstraction;

public class Main {
    public static void main(String[] args) {
        Character dextomi = new Warrior("dextomi");
        Character iseka = new Archer("iseka");

        while (dextomi.getHealth() > 0 && iseka.getHealth() > 0) {
            if (dextomi.getHealth() > 0) {
                dextomi.attack(iseka);
                System.out.printf("dextomi did %d damage, iseka's current health is %d\n",
                        dextomi.getStrength(), iseka.getHealth());
            }
            if (iseka.getHealth() > 0) {
                iseka.attack(dextomi);
                System.out.printf("iseka did %d damage, dextomi's current health is %d\n",
                        iseka.getAgility(), dextomi.getHealth());
            }
            if (dextomi.getHealth() == 0) {
                System.out.println("iseka wins!");
            }
            if (iseka.getHealth() == 0) {
                System.out.println("dextomi wins!");
            }
        }
    }
}
