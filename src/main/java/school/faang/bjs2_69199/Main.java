package school.faang.bjs2_69199;

public class Main {
    private static final int ROUNDS = 15;

    public static void main(String[] args) {
        Character gimli = new Warrior("Gimli");
        Character legolas = new Archer("Legolas");

        for (int i = 0; i < ROUNDS; i++) {
            gimli.attack(legolas);
            legolas.attack(gimli);
            System.out.printf("Gimli's health %d -- Legala's health %d\n", gimli.getHealth(), legolas.getHealth());
        }
    }
}
