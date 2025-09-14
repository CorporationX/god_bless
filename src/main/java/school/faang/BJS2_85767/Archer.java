package school.faang.BJS2_85767;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        opponent.takeDamage(this.agility);
        System.out.println(this.name + " выстрелил в " + opponent.name + " и нанёс "
                + this.agility + " урона. ");
    }
}