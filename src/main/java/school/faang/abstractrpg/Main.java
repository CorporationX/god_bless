package school.faang.abstractrpg;

public class Main {
    public static void main(String[] args) {
        Character torin = new Warrior("Torrin");
        Character legalas = new Archer("Legalas");
        torin.attack(legalas);
        torin.attack(legalas);
        legalas.attack(torin);
    }
}
