package faang.school.godbless.BJS2_25200;

import java.util.Set;

public class DemonEdge extends Item {
    public static final DemonEdge DEMON_EDGE;

    static {
        DEMON_EDGE = new DemonEdge();
        Recipe recipe = new Recipe(Daedalus.DAEDALUS, Set.of(
                DEMON_EDGE,
                Crystalis.CRYSTALIS
        ));
        DEMON_EDGE.initRecipe(recipe);
    }

    private DemonEdge() {
        super("Demon Edge", 45);
    }
}
