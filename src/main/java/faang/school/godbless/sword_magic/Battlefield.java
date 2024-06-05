package faang.school.godbless.sword_magic;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class Battlefield {
    @NonNull
    private final Hero heroOfLight;
    @NonNull
    private final Hero heroOfDarkness;

    public Hero battle(){
        System.out.println("The army of the Hero of Light " + heroOfLight.getName() + " has: ");
        heroOfLight.showArmy();

        System.out.println("The army of the Hero of Darkness " + heroOfDarkness.getName() + " has: ");
        heroOfDarkness.showArmy();

        int damageOfLight = heroOfLight.getDamageOfArmy();
        int armorOfLight = heroOfLight.getArmorOfArmy();
        int powerOfLightArmy = damageOfLight + armorOfLight;

        int damageOfDarkness = heroOfDarkness.getDamageOfArmy();
        int armorOfDarkness = heroOfDarkness.getArmorOfArmy();
        int powerOfDarknessArmy = damageOfDarkness + armorOfDarkness;

        if(powerOfLightArmy > powerOfDarknessArmy){
            System.out.println(heroOfLight.getName() + " from " + heroOfLight.getFraction() + " wins!");
            return heroOfLight;
        } else if(powerOfLightArmy < powerOfDarknessArmy){
            System.out.println(heroOfDarkness.getName() + " from " + heroOfDarkness.getFraction() + " wins!");
            return heroOfDarkness;
        } else {
            System.out.println("It was a hard battle, no one survived. It's a draw");
            return null;
        }
    }
}
