package school.faang.bjs2_89569;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Knight knightOne = new Knight("Knight One");
        knightOne.addTrial(new Trial(knightOne.getName(), "of agility"));
        knightOne.addTrial(new Trial(knightOne.getName(), "of strength"));
        knightOne.addTrial(new Trial(knightOne.getName(), "of intelligence"));

        Knight knightTwo = new Knight("Knight Two");
        knightTwo.addTrial(new Trial(knightTwo.getName(), "of vitality"));
        knightTwo.addTrial(new Trial(knightTwo.getName(), "of luck"));
        List<Knight> knights = List.of(knightOne, knightTwo);

        for (Knight knight : knights) {
            knight.startTrials();
        }
    }
}
