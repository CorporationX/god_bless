public class Warrior extends java.lang.Character {
    public Warrior(String name) {
        super(name);
        this.power = 10;
        this.agility = 5;
        this.intelligence = 3;
    }
    @Override
    public void attack(java.lang.Character character) {
        int damage = this.power;
        character.health -= this.power;
        System.out.println(this.name + " attack " + character.name + " with strength " + damage);
    }
}
