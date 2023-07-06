package faang.school.godbless.Sprint5.Task2_StarWars;

public class Robot {
    private String name;
    private int attackPower;
    private int defensePower;

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