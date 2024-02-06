package faang.school.godbless.abstraction;

public class Warrior extends Character{
//для Warrior сила всегда выставляется в 10, ловкость в 5, интеллект в 3. Имя передаётся извне;


    public Warrior(String name) {
        super(name, 10, 5,3);
    }
    @Override
    public void attack(Character character) {
        character.hp -= power;
    }
}
