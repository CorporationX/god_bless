package school.faang.WOW;


import lombok.Getter;

@Getter
public class Player {
    private final String name;
    private final int level;
    private int exp;

    public Player(String name, int level, int exp) {
        this.name = name;
        this.level = level;
        this.exp = exp;
    }

    public void addExperience(int amount) {
        this.exp += amount;
    }
}