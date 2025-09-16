package bjs2_85721;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3); // сила 10, ловкость 5, интеллект 3
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.getStrength();
        opponent.takeDamage(damage);
        System.out.println(this.getName() + " ударил мечом " + opponent.getName()
                + " на " + damage + " урона. У " + opponent.getName()
                + " осталось " + opponent.getHealth() + " здоровья.");
    }
}