package bjs2_85721;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5); // сила 3, ловкость 10, интеллект 5
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.getAgility();
        opponent.takeDamage(damage);
        System.out.println(this.getName() + " выстрелил в " + opponent.getName()
                + " на " + damage + " урона. У " + opponent.getName()
                + " осталось " + opponent.getHealth() + " здоровья.");
    }
}