package faang.school.godbless.tournament_king_landing;

public class King {
    public static void main(String[] args) {
        Knight knightArtur = new Knight("Artur");
        Knight knightHenry = new Knight("Henry");

        knightArtur.addTrial(new Trial(knightArtur.getName(), "Riding a horse"));
        knightArtur.addTrial(new Trial(knightArtur.getName(), "Javelin-throwing"));
        knightHenry.addTrial(new Trial(knightHenry.getName(), "Riding a horse"));
        knightHenry.addTrial(new Trial(knightHenry.getName(), "Javelin-throwing"));

        knightArtur.startTrials();
        knightHenry.startTrials();
    }
}
