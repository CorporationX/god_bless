package faang.school.godbless;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    public Archer(String name, int power, int agility, int intelligence) {
        super(name, power, agility, intelligence);
    }

    @Override
    public void attack(Character character) {
        character.health -= super.power;
    }

    @Override
    public String toString() {
        return "Archer{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                ", health=" + health +
                '}';
    }

}
