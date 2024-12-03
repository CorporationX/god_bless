package school.faang.abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name, ARCHER_POWER, ARCHER_AGILITY, ARCHER_INTELLECT);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.agility;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Archer{");
        sb.append("name='").append(name).append('\'');
        sb.append(", power=").append(power);
        sb.append(", agility=").append(agility);
        sb.append(", intellect=").append(intellect);
        sb.append(", health=").append(health);
        sb.append('}');
        return sb.toString();
    }
}
