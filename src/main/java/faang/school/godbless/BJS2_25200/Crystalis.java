package faang.school.godbless.BJS2_25200;

import java.util.Set;

public class Crystalis extends Item {
    public static final Crystalis CRYSTALIS;

    static {
        CRYSTALIS = new Crystalis();
        Recipe recipe = new Recipe(Daedalus.DAEDALUS, Set.of(
                CRYSTALIS,
                DemonEdge.DEMON_EDGE
        ));
        CRYSTALIS.initRecipe(recipe);
    }

    private Crystalis() {
        super("Crystalis", 60);
    }
}
