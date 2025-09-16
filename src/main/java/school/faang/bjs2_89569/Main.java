package school.faang.bjs2_89569;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Knight knightOne = new Knight("Knight One");
        knightOne.addTrial(new Trial(knightOne.getName(), "trial of agility"));
        knightOne.addTrial(new Trial(knightOne.getName(), "trial of strength"));
        knightOne.addTrial(new Trial(knightOne.getName(), "trial of intelligence"));

        Knight knightTwo = new Knight("Knight Two");
        knightTwo.addTrial(new Trial(knightTwo.getName(), "trial of vitality"));
        knightTwo.addTrial(new Trial(knightTwo.getName(), "trial of luck"));
        List<Knight> knights = List.of(knightOne, knightTwo);

        for (Knight knight : knights) {
            knight.startTrials();
        }
    }
}
