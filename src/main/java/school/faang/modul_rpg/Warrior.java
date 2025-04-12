package school.faang.modul_rpg;

class Warrior extends Character {
    public static final int strange = 10;
    public static final int agility = 5;
    public static final int intelligence = 3;

    public Warrior(String name) {
        super(name, strange, agility, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s attacks %s for %d damage!%n", name, opponent.getName(), strength);
        opponent.takeDamage(strength);
    }
}