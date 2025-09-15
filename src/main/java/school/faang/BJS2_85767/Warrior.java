package school.faang.BJS2_85767;

import school.faang.BJS2_85767.Character;

public class Warrior extends Character {
    private static final  int WARRIOR_STRENGTH = 10;
    private static final  int WARRIOR_AGILITY = 5;
    private static final  int WARRIOR_INTELLIGENCE = 3;
    public Warrior(String name) {
        super(name, WARRIOR_STRENGTH, WARRIOR_AGILITY, WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        opponent.takeDamage(this.strength);
        System.out.println(this.name + " ударил " + opponent.name + " и нанёс "
                + this.strength + " урона. ");
    }
}