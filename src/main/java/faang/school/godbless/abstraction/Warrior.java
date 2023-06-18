import lombok.Getter;

@Getter
public class Warrior extends Character{
    private static final int POWER = 10;
    private static final int SLEIGHT = 5;
    private static final int INTELLECT = 3;
    private String name;


    protected Warrior(String name) {
        super(name);
    }

    protected Warrior() {
        super(POWER, SLEIGHT, INTELLECT);
    }

    @Override
    public void attack(Character character) {
        if(health<POWER) {
            throw new IllegalArgumentException("Archer dead");
        }
        else{
            health = health - POWER;
            System.out.println(health);
        }
    }
}
