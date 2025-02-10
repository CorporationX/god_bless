package school.faang;

class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(getName() + "Аттакует" + opponent.getName());
        opponent.takeDamage(10);
    }
}


