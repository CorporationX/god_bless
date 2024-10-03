package school.faang;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character enemy) {
        enemy.health -= this.strength; // Урон противнику - это сила воина
        System.out.println(this.name + " атакует - " + enemy.name + " нанося : " + this.strength + " урон");
    }
}
