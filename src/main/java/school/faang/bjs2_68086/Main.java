package school.faang.bjs2_68086;

public class Main {
    public static void main(String[] args) {
        Warrior war = new Warrior("UberWar");
        Archer hunter = new Archer("Hunter");

        war.attack(hunter);
        System.out.printf("Hunter health after exchange: %d \n", hunter.getHealth());
        hunter.attack(war);
        System.out.printf("Warrior health after exchange: %d \n", war.getHealth());
        for (int i = 0; i < 8; i++) {
            war.attack(hunter);
        }
        System.out.printf("Hunter health after war attacks: %d \n", hunter.getHealth());
        System.out.println("Warrior uses his finisher");
        System.out.printf("Hunter health = %d \n", hunter.getHealth());
        war.attack(hunter);
    }
}
