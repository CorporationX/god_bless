package faang.school.godbless.week1;

public class Warrior extends Character {
    //Set warrior who can only accept name you give
    public Warrior(String name) {
        super(name, 10, 5, 3);//Set stats for war
    }

    //Now with what stats he can attack
    @Override
    public void attack(Character target) {
        int damage = this.getStrength();
        target.setHealth(target.getHealth() - damage);
        System.out.println(this.getName()+" attacks "+ target.getName()+ " for "+ damage+ " damage. ");
    }
}
