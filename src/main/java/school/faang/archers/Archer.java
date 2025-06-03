package school.faang.archers;

import school.faang.bjs2_79203_characters.Character;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        opponent.takeDamage(this.agility);
        System.out.println(this.name + " стреляет в " + opponent.getName() + " на " + this.agility + " урона (Ловкость)");
    }
}
