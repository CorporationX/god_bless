package school.faang;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s стреляет в %s с ловкостью %d%n", this.name, opponent.getName(), this.agility);
        opponent.reduceHealth(this.agility);
    }
}
