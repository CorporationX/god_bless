package faang.school.godbless.BJS2_23433;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        var vupsen = new Knight("Pupsen");
        var pupsen = new Knight("Vupsen");

        vupsen.addTrial(new Trial(vupsen.getName(), "jump 5 meters high"));
        vupsen.addTrial(new Trial(vupsen.getName(), "swim through the sharks"));
        vupsen.addTrial(new Trial(vupsen.getName(), "don't breathe 3 min"));

        pupsen.addTrial(new Trial(pupsen.getName(), "jump"));
        pupsen.addTrial(new Trial(pupsen.getName(), "do a flip"));
        pupsen.addTrial(new Trial(pupsen.getName(), "tell a joke"));

        ExecutorService service = Executors.newFixedThreadPool(2);

        vupsen.startTrials(service);
        pupsen.startTrials(service);

        service.shutdown();
    }
}
