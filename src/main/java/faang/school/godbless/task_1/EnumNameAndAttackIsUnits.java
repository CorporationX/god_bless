package faang.school.godbless.task_1;

public enum EnumNameAndAttackIsUnits {
    PIKEMAN("Pikeman", 3),
    GRIFFIN("Griffin", 5),
    SWORDMAN("Swordman", 2),
    ANGEL("Angel", 8);


    private final String name;
    private final int atack;

    EnumNameAndAttackIsUnits(String name, int atack) {
        this.name = name;
        this.atack = atack;
    }

    public String getName() {
        return name;
    }
    public int getAtack() {
        return atack;
    }
}
