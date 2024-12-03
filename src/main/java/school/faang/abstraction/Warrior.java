package school.faang.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, WARRIOR_POWER, WARRIOR_AGILITY, WARRIOR_INTELLECT);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.power;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Warrior{");
        sb.append("name='").append(name).append('\'');
        sb.append(", power=").append(power);
        sb.append(", agility=").append(agility);
        sb.append(", intellect=").append(intellect);
        sb.append(", health=").append(health);
        sb.append('}');
        return sb.toString();
    }
}
