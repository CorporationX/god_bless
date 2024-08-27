package faang.school.godbless.BJS2_25200;

import java.util.Set;

public class BladesOfAttack extends Item {
    public static final BladesOfAttack BLADES_OF_ATTACK;

    static {
        BLADES_OF_ATTACK = new BladesOfAttack();
        Recipe recipe = new Recipe(Crystalis.CRYSTALIS, Set.of(
                Claymore.CLAYMORE,
                BLADES_OF_ATTACK
        ));
        BLADES_OF_ATTACK.initRecipe(recipe);
    }

    private BladesOfAttack() {
        super("Blades Of Attack", 20);
    }
}
