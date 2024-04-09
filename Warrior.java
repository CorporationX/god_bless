public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.power = 10;
        this.agility = 5;
        this.intelligence = 3;
    }
    @Override
    public void attack(Character character) {
        int damage = this.power;
        character.health -= this.power;
        System.out.println(this.name + " attack " + character.name + " with strength " + damage);
    }
}
