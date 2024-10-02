package abstraction;


public class Main {
    public static void main(String[] args){
        Warrior warrior = new Warrior("Victor");
        Archer archer = new Archer("Arnold");
        Warrior warrior2 = new Warrior("Lee");
        Archer archer2 = new Archer("Ray");

//        Archer archer3 = new Archer("");

        warrior.attack(archer);
        archer2.attack(warrior2);
        archer.attack(archer2);



    }
}
