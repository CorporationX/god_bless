package faang.school.godbless.thirdSprint.Tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);

        Knight bib = new Knight("Bib");
        Knight bob = new Knight("Bob");
        bib.addTrial(new Trial("Bib", "go to bed before 2 am"));
        bib.addTrial(new Trial("Bib", "not eating pizza for 1 day"));
        bob.addTrial(new Trial("Bob", "don't swear for 5 minutes"));
        bob.addTrial(new Trial("Bob", "wash dishes after eating"));

        service.submit(bib::startTrials);
        service.submit(bob::startTrials);
        service.shutdown();
    }
}
