package Heroes_of_Might_and_Magick;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Battlefield {
    private Hero heroOne;
    private Hero heroTwo;

    public static Hero battle(Hero heroOne, Hero heroTwo) {
        int heroOneTotalAttack = heroOne.getTotalAttack();
        int heroTwoTotalAttack = heroTwo.getTotalAttack();
        System.out.println(heroOne.getName() + " Аттака армии: " + heroOneTotalAttack);
        System.out.println(heroTwo.getName() + " Аттака армии: " + heroTwoTotalAttack);
        if (heroOneTotalAttack > heroTwoTotalAttack) {
            return heroOne;
        } else if (heroOneTotalAttack < heroTwoTotalAttack) {
            return heroTwo;
        } else {
            return null;
        }
    }
}

