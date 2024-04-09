public class Archer extends Character{
    public Archer (String name) {
        super(name);
        this.power = 3;
        this.agility = 10;
        this.intelligence = 5;
    }
    @Override
    public void attack(Character character) {
        int damage = this.agility;
        character.health -= this.power;
        System.out.println(this.name + " attack " + character.name + " with strength " + damage);
    }
}
