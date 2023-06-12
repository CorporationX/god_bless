package faang.school.godbless;

public class Archer extends Character{
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.agility);
    }

    @Override
    public String toString() {
        return "Archer{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", agility=" + agility +
                ", intelligent=" + intelligent +
                ", health=" + health +
                '}';
    }
}
