package faang.school.godbless.BJS2_18932;

public class Main {
    private static final String PROTAGONIST_NAME = "John";
    private static final String PROTAGONIST_FRACTION = "Light";
    private static final int PROTAGONIST_EXP = 30;
    private static final int PROTAGONIST_LVL = 2;

    private static final String ANTAGONIST_NAME = "Frank";
    private static final String ANTAGONIST_FRACTION = "Dark";
    private static final int ANTAGONIST_EXP = 10;
    private static final int ANTAGONIST_LVL = 5;

    private static Hero protagonist = new Hero(PROTAGONIST_NAME, PROTAGONIST_FRACTION, PROTAGONIST_EXP, PROTAGONIST_LVL);
    private static Hero antagonist = new Hero(ANTAGONIST_NAME, ANTAGONIST_FRACTION, ANTAGONIST_EXP, ANTAGONIST_LVL);

    public static void main(String[] args) {
        protagonist.addCreature(new Angel(), 1);
        protagonist.addCreature(new Pikerman(), 100);
        protagonist.removeCreature(new Pikerman(), 100);
        protagonist.viewArmy();
        System.out.println();

        antagonist.addCreature(new Griffin(), 2);
        antagonist.addCreature(new Swordman(), 50);
        antagonist.removeCreature(new Swordman(), 50);
        antagonist.viewArmy();
        System.out.println();

        Battlefield battlefield = new Battlefield(protagonist, antagonist);
        Hero winner = battlefield.battle();
        System.out.println(winner);
    }
}
