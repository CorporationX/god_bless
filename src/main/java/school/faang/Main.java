package school.faang;

public class Main {
    public static void main(String[] args) {
        Warrior warrior=new Warrior("warrior");
        Archer archer=new Archer("archer");
        while (archer.HeathPoints>0){
            warrior.attack(archer);
        }
        System.out.println(warrior.name+" "+warrior.HeathPoints);
        System.out.println(archer.name+" "+archer.HeathPoints);
    }
}
