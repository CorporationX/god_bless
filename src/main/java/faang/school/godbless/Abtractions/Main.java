package faang.school.godbless.Abtractions;

public class Main {
    public static void main(String[] args) {
        Archer volodya = new Archer("Volodya");
        Warrior oleg = new Warrior("Oleg");

        System.out.println(volodya.getName() + ": " + volodya.getHp() + " "  + oleg.getName() + ": " + oleg.getHp());

        volodya.attack(oleg);
        oleg.attack(volodya);

        System.out.println(volodya.getName() + ": " + volodya.getHp() + " "  + oleg.getName() + ": " + oleg.getHp());
    }
}
