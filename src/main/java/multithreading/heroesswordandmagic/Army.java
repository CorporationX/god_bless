package multithreading.heroesswordandmagic;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
public class Army {

    List<Warriors> warriors = new ArrayList<>();

    public int calculateTotalPower() {
       return warriors.stream().mapToInt(Warriors::getPower).sum();
    }

    public static void main(String[] args) {
        List<Warriors> warriors = new ArrayList<>();
        warriors.add(new Swordsman(10));
        warriors.add(new Mage(15));
        warriors.add(new Archer(5));

        Army army = new Army();
        army.setWarriors(warriors);

        System.out.println(army.calculateTotalPower());;

    }
}
