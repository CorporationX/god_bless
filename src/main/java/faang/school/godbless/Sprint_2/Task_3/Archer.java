package faang.school.godbless.Sprint_2.Task_3;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.agility;
    }

    @Override
    public String toString() {
        return "Archer{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                ", health=" + health +
                '}';
    }
}
