package faang.school.godbless;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Battlefield {
    private Hero firstHero;
    private Hero secondHero;

    public String battle() {
        int firsHeroAttack = firstHero.totalArmyAttack();
        int firsHeroDefense = firstHero.totalArmyDefense();
        int secondHeroAttack = secondHero.totalArmyAttack();
        int secondHeroDefense = secondHero.totalArmyDefense();

        info();
        if ((firsHeroAttack - secondHeroDefense) > (secondHeroAttack - firsHeroDefense)) {
            return "First Hero wins";
        } else {
            return "Second Hero wins";
        }
    }

    private void info() {
        System.out.println("Army of " + firstHero.getName());
        firstHero.printArmy();
        System.out.println(" VS ");
        System.out.println("Army of " + secondHero.getName());
        secondHero.printArmy();
        System.out.println("RESULT:");
    }


}
