package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        Character artur = new Warrior("Artur");
        Character egor = new Archer("Egor");
        Character oleg = new StartHero("oleg");

        egor.attack(artur);
        oleg.attack(artur);

        for (int i = 0; i < 12; i++) {
            artur.attack(egor);
        }
        System.out.println("ХP егора: " + egor.getHealth() + "\nХP артура: " + artur.getHealth());
    }
}