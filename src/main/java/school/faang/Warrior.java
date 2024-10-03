package school.faang;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    void attack(Character target) {
        int damage = getPower();

        target.setHealth(target.getHealth() - damage);
        System.out.printf("Warrior атакует %s и наносит урона %s, осталось " +
                        "здоровья: %s\n",
                target.getName()
                , damage, target.getHealth());
    }
}
