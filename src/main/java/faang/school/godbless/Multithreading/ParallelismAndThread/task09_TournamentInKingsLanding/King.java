package faang.school.godbless.Multithreading.ParallelismAndThread.task09_TournamentInKingsLanding;

import lombok.SneakyThrows;

public class King {
    @SneakyThrows
    public static void main(String[] args) {
        Knight knight1 = new Knight("FirstKnight");
        Knight knight2 = new Knight("SecondKnight");

        knight1.addTrial(new Trial(knight1.getName(), "Trial 1"));
        knight1.addTrial(new Trial(knight1.getName(), "Trial 2"));

        knight2.addTrial(new Trial(knight2.getName(), "Trial 1"));
        knight2.addTrial(new Trial(knight2.getName(), "Trial 2"));

        knight1.startTrials();
        knight2.startTrials();
    }
}
