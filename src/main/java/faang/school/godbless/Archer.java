package faang.school.godbless;

public class Archer extends Character{

    public Archer(String name) {
        //для Archer сила всегда выставляется в 3, ловкость в 10, интеллект в 5.
        super(name);
        this.str = 3;
        this.dex = 10;
        this.intellect = 5;
    }

    @Override
    public void Attack(Character target) {
        int damage = this.dex;
        target.hp=target.hp - damage;
    }
    //в {{Warrior}}персонаж наносит урон противнику в количестве собственной силы.
    // У противника отнимается столько же очков здоровья, сколько он получает урона;

}
