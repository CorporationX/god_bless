package school.faang.task_43842;

class Archer extends Character {
    private static final int INIT_STRENGTH = 3;
    private static final int INIT_AGILITY = 10;
    private static final int INIT_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, INIT_STRENGTH, INIT_AGILITY, INIT_INTELLIGENCE);
    }

    @Override
    public void attack(Character target) {
        int damage = getAgility();
        target.setHealth(target.getHealth() - damage);
        System.out.println(getName() + " (Archer) attacked "
                + target.getName() + " and inflicts " + damage + " damage");
    }
}
