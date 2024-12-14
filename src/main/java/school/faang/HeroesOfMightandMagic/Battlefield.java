package school.faang.HeroesOfMightandMagic;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Hero battle(){
        int hero1Power = hero1.getHeroPower();
        int hero2Power = hero2.getHeroPower();
        if (hero1Power > hero2Power) {
            return hero1;
        } else if (hero2Power > hero1Power) {
            return hero2;
        } else {
            return null;
        }
    }

    public void printResult(){
        if (battle() != null) {
            System.out.println(battle().getName() + " wins!");
        } else {
            System.out.println("Draw!");
        }
    }
}
