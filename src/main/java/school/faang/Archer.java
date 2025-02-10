package school.faang;

class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(getName() + "Аттакует" + opponent.getName());
        opponent.takeDamage(10);
    }
}
