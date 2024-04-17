package faang.school.godbless.tournament;

public class King {

    public static void main(String[] args) {
        Knight Artur = new Knight("Artur");
        Knight Peter = new Knight("Peter");

        Artur.addTrial(new Trial("Artur", "vacuuming"));
        Artur.addTrial(new Trial("Artur", "fighting"));

        Peter.addTrial(new Trial("Peter", "do the homework"));
        Peter.addTrial(new Trial("Peter", "Save the princess"));

        Artur.startTrials();
        Peter.startTrials();

    }


}
