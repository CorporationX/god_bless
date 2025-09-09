package school.faang.bjs2_85621.Character;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        super.strength = 11;
        super.agility = 5;
        super.intelligence = 3;
    }

    @Override
    public void attack(Character opponent) {
        while (opponent.health > 0) {
            opponent.health -= strength;
        }
        opponent.checkHealth(opponent.health);
        System.out.println(name + " одолел " + opponent.name);
    }
}
