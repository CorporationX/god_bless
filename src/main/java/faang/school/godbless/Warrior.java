package faang.school.godbless;

public class Warrior extends Character{

    public Warrior(String name) {
        //для Warrior сила всегда выставляется в 10, ловкость в 5, интеллект в 3.
        super(name);
        this.str = 10;
        this.dex = 5;
        this.intellect = 3;
    }

    @Override
    public void Attack(Character target) {
        int damage = this.str;
        target.hp=target.hp - damage;
    }
    //в {{Warrior}}персонаж наносит урон противнику в количестве собственной силы.
    // У противника отнимается столько же очков здоровья, сколько он получает урона;

}

