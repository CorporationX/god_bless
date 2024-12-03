package school.faang.abstraction;

public class Archer extends Character {

    public Archer(String name, int power, int agility, int intellect) {
        super(name);
        power = 3;
        agility = 10;
        intellect = 5;
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
