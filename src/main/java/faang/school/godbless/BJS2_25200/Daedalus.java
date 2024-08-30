package faang.school.godbless.BJS2_25200;

public class Daedalus extends Item {
    public static final Daedalus DAEDALUS;

    static {
        DAEDALUS = new Daedalus();
        DAEDALUS.initRecipe(Recipe.EMPTY);
    }

    private Daedalus() {
        super("Daedalus", 140);
    }
}