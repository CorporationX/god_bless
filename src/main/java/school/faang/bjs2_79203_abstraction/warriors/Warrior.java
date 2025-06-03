package school.faang.bjs2_79203_abstraction.warriors;

import school.faang.bjs2_79203_abstraction.Character;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        opponent.takeDamage(this.strength);
        System.out.println(this.name + " атакует " + opponent.getName() + " на " + this.strength + " урона (Сила)");
    }
}