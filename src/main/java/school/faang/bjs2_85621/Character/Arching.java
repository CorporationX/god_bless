package school.faang.bjs2_85621.Character;

public class Arching extends Character {
    public Arching(String name) {
        super(name);
        super.strength = 3;
        super.agility = 12;
        super.intelligence = 5;
    }

    @Override
    public void attack(Character opponent) {
        while (opponent.health > 0) {
            opponent.health -= agility;
        }
        opponent.checkHealth(opponent.health);
        System.out.println(name + " одолел " + opponent.name);
    }
}
