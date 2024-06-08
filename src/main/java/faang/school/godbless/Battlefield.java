package faang.school.godbless;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Battlefield {
    private Hero firstHero;
    private Hero secondHero;

    public String battle() {
        String result = "";
        int firsHeroDefense = firstHero.totalArmyDefense();
        int secondHeroDefense = secondHero.totalArmyDefense();
        int firstHeroHealth = firstHero.totalArmyHealth();
        int secondHeroHealth = secondHero.totalArmyHealth();
        int round = 1;
        info();
        while (firstHeroHealth > 0 && secondHeroHealth >0) {
            System.out.println("Step #" + round);


            int firsHeroAttack = firstHero.totalArmyAttack();
            int secondHeroAttack = secondHero.totalArmyAttack();

            firstHeroHealth -= (secondHeroAttack - firsHeroDefense);
            secondHeroHealth -= (firsHeroAttack - secondHeroDefense);

            System.out.println(firstHero.getName() + " army Attack: " + firsHeroAttack);
            System.out.println(secondHero.getName() + " army Attack: " + secondHeroAttack);
            System.out.println(firstHero.getName() + " remaining total health: " + firstHeroHealth);
            System.out.println(secondHero.getName() + " remaining total health: " + secondHeroHealth);
            round++;
        }

        if (firstHeroHealth < secondHeroHealth) result = secondHero.getName() + " wins!!!";
        else if (firstHeroHealth == secondHeroHealth) result = "Draw";
        else result = firstHero.getName() + " wins!!!";

        return result;
    }

    private void info() {
        System.out.println("Army of " + firstHero.getName());
        firstHero.printArmy();
        System.out.println(" VS ");
        System.out.println("Army of " + secondHero.getName());
        secondHero.printArmy();
        System.out.println("The Battle begins");
    }

}
