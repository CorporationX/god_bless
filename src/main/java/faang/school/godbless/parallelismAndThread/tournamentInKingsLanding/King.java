package faang.school.godbless.parallelismAndThread.tournamentInKingsLanding;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Peter");
        Knight knight2 = new Knight("Philipp");

        knight1.addTrial(new Trial(knight1.getName(), "trial1"));
        knight1.addTrial(new Trial(knight1.getName(), "trial2"));

        knight2.addTrial(new Trial(knight2.getName(), "trial3"));
        knight2.addTrial(new Trial(knight2.getName(), "trial4"));

        knight1.startTrials(2);
        knight2.startTrials(2);
    }
}
