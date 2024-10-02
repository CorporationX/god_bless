package school.faang;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    void attack(Character target) {
        int damage = dexterity;
        target.health -= damage;
        System.out.printf("Archer атакует %s и наносит урона %s, осталось " +
                        "здоровья: %s\n",
                target.name
                , damage, target.health);
    }
}
