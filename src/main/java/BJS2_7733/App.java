package BJS2_7733;

public class App {
    public static void main(String[] args) {

        Warrior warrior01 = new Warrior("W1");
        Archer archer01 = new Archer("A1");
        System.out.println(warrior01.hp + " " + archer01.hp+"\n");
        warrior01.attack(archer01);
        System.out.println(warrior01.hp +" "+ archer01.hp+"\n");
        archer01.attack(warrior01);
        System.out.println(warrior01.hp +" "+ archer01.hp+"\n");
    }
}