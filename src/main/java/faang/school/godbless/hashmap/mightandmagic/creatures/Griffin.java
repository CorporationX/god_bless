package faang.school.godbless.hashmap.mightandmagic.creatures;

public class Griffin extends Creature {

    private static final String NAME = "Griffin";
    private static final int LEVEL = 2;
    private static final int ATTACK = 8;
    private static final int DEFENSE = 5;
    private static final int SPEED = 6;
    private static final int HP = 25;


    public Griffin(int quantity) {
        super(NAME, LEVEL, ATTACK, DEFENSE, SPEED, HP, quantity);
    }

}
