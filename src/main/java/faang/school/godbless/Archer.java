package faang.school.godbless;

public class Archer extends Character {
    public Archer(String name){
        super(name);
        this.name = name;
        setDefaultCharacteristics();
    }

    public Archer(String name, int power, int agility, int intelligence){
        super(name,power,agility,intelligence);
        setDefaultCharacteristics();
    }

    private void setDefaultCharacteristics(){
        this.power = 3;
        this.agility = 10;
        this.intelligence = 5;
    }

    @Override
    public void attack(Character enemy) {
        enemy.setHealthPoints(enemy.healthPoints-this.getAgility());
        System.out.println(enemy.getName() + " has " + enemy.getHealthPoints() + " health points left " );
    }
}
