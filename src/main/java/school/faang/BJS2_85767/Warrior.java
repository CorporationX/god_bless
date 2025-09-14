package school.faang.BJS2_85767;

import school.faang.BJS2_85767.Character;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        opponent.takeDamage(this.strength);
        System.out.println(this.name + " ударил " + opponent.name + " и нанёс "
                + this.strength + " урона. ");
    }
}