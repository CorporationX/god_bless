package faang.school.godbless;

public class Battlefield {
    private Hero firstHero;
    private Hero secondHero;

    public void initArmy(Hero hero) {
        hero.addCreature(new Pikeman());
        hero.addCreature(new Griffin());
        hero.addCreature(new Swordman());
        hero.addCreature(new Angel());
    }

    public void battle() {
        firstHero = new Hero("Axe", "Dire", 0, 1);
        initArmy(firstHero);
        secondHero = new Hero("Urse", "Radiant", 0, 1);
        initArmy(secondHero);

        int damageFirstArmy = firstHero.totalDamageArmy(firstHero.getArmy());
        int damageSecondArmy = secondHero.totalDamageArmy(secondHero.getArmy());

        System.out.println("Сражение началось!");
        System.out.println("Сила армии " + firstHero.getName() + " = " + damageFirstArmy);
        System.out.println("Сила армии " + secondHero.getName() + " = " + damageSecondArmy);

        if (damageFirstArmy > damageSecondArmy) {
            System.out.println("Победитель: " + firstHero.getName());
        } else if (damageFirstArmy < damageSecondArmy){
            System.out.println("Победитель: " + secondHero.getName());
        } else {
            System.out.println("Ничья!");
        }
    }
}
