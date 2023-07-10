package faang.school.godbless.spring_4.star_wars_arena;

public class Robot {
    private String name;
    private int attackPower;
    private int defensePower;

    public Robot(String name, int attackPower, int defensePower) {
        this.name = name;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setDefensePower(int defensePower) {
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

    @Override
    public String toString() {
        return name;
    }
}
