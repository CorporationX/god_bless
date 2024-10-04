public class Warrior extends Character{
    private String name;

    public Warrior(int power, int skil,int intelligence,String name) {
        super(power = 10, skil = 5, intelligence = 3);
        this.name = name;
    }

    @Override
    public void attack(Character character) {
        health = health - character.power  ;

    }
}
