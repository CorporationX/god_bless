package school.faang.BJS2_56371.characters;

import school.faang.BJS2_56371.character.Character;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(getName() + " атакует " + opponent.getName() + " с ловкостью " + getAgility());
        opponent.setHealth(getAgility());
    }
}
