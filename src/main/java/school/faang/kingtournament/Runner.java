package school.faang.kingtournament;

public class Runner {

    public static void main(String[] args) {
        Knight lord = new Knight("Lord");
        Knight bob = new Knight("Bob");
        lord.addTrial(new Trial("Run", lord.getName()));
        bob.addTrial(new Trial("Run", bob.getName()));
        lord.addTrial(new Trial("Fight", lord.getName()));
        bob.addTrial(new Trial("Fight", bob.getName()));
        lord.startTrials();
        bob.startTrials();


    }
}
