package faang.school.godbless.starwarsarena;

public class Robot {
    private final String name;
    private final int attackPower;
    private final int defensePower;

    public Robot(String name, int attackPower, int defensePower) {
        this.name = name;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
    }

    public String getName() {
        return name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefensePower() {
        return defensePower;
    }
}
