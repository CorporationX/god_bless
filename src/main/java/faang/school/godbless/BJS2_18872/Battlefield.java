package faang.school.godbless.BJS2_18872;

public class Battlefield {

    private Hero firstHero;
    private Hero secondHero;

    public Battlefield(Hero firstHero, Hero SecondHero) {
        this.firstHero = firstHero;
        this.secondHero = SecondHero;
    }

    public Hero battle() {
        int damageHero1 = firstHero.calculateTotalDamage();
        int damageHero2 = secondHero.calculateTotalDamage();

        System.out.println(firstHero.getName() + " damage " + damageHero1 + " to " + secondHero.getName());
        System.out.println(secondHero.getName() + " damage " + damageHero2 + " to " + firstHero.getName());

        if (damageHero1 > damageHero2) {
            System.out.println(firstHero.getName() + " won!");
            firstHero.setExperience(firstHero.getExperience() + 1000);
            return firstHero;
        } else if (damageHero2 > damageHero1) {
            System.out.println(secondHero.getName() + " won!");
            firstHero.setExperience(secondHero.getExperience() + 1000);
            return secondHero;
        } else {
            System.out.println("Tie!");
            return null;
        }
    }
}
