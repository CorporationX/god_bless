package faang.school.godbless.BJS2_4215;

class Warrior extends Character{
    public Warrior(String name){
        super(name);
    }
    public Warrior(int strength, int agility, int intellect){
        super(10,5,3);
    }
    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getStrength());
    }

}




