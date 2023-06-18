import lombok.Getter;

@Getter
public class Archer extends Character{
    private static final int POWER = 3;
    private static final int SLEIGHT = 10;
    private static final int INTELLECT = 5;
    private String name;

    protected Archer(String name) {
        super(name);
    }

    protected Archer() {
        super(POWER, SLEIGHT, INTELLECT);
    }

    @Override
    public void attack(Character character) {
        if(health<SLEIGHT) {
            throw new IllegalArgumentException("Warrior dead");
        }
        else{
            health = health - SLEIGHT;
            System.out.println(health);
        }
    }
}
