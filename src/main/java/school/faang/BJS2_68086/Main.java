package school.faang.BJS2_68086;

public class Main {
    public static void main(String[] args) {
        Warrior war = new Warrior("UberWar");
        Archer hunter = new Archer("Hunter");

        war.attack(hunter);
        System.out.println("Hunter health after exchange: " + hunter.health);
        hunter.attack(war);
        System.out.println("Warrior health after exchange : " + war.health);
        for (int i = 0; i < 8; i++) {
            war.attack(hunter);
        }
        System.out.println("Hunter health after war attacks: " + hunter.health);
        System.out.println("Warrior uses his finisher");
        war.attack(hunter);
    }
}
