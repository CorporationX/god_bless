package HeroesOfMightAndMagic.creatures;

public class Pikeman extends Creature{

    public Pikeman(String name) {
        super(name);
        this.armor = 10;
        this.damage = 50;
        this.health = 500;
        this.level = 3;
        this.speed = 50;
    }
}
