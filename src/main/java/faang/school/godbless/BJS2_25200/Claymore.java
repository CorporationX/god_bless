package faang.school.godbless.BJS2_25200;

import java.util.Set;

public class Claymore extends Item {
    public static final Claymore CLAYMORE;

    static {
        CLAYMORE = new Claymore();
        Recipe recipe = new Recipe(Crystalis.CRYSTALIS, Set.of(
                CLAYMORE,
                BladesOfAttack.BLADES_OF_ATTACK
        ));
        CLAYMORE.initRecipe(recipe);
    }

    private Claymore() {
        super("Claymore", 30);
    }
}
