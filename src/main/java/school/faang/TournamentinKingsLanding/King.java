package school.faang.TournamentinKingsLanding;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class King {
    private String name;
    private final List<Knight> knightList;

    public King(String name) {
        this.name = name;
        this.knightList = new ArrayList<>();
    }

    public static void main(String[] args) throws InterruptedException {
        Knight arthur = new Knight("Arthur");
        Knight bob = new Knight("Bob");

        arthur.addTrial(new Trial(arthur.getName(), "Trial I"));
        arthur.addTrial(new Trial(arthur.getName(), "Trial II"));
        bob.addTrial(new Trial(bob.getName(), "Trial III"));
        bob.addTrial(new Trial(bob.getName(), "Trial IV"));

        King king = new King("Jack");
        king.addKnight(arthur);
        king.addKnight(bob);

        ExecutorService service = Executors.newFixedThreadPool(2);

        king.getKnightList().forEach(e -> e.startTrials(service));

        service.shutdown();

        if(service.awaitTermination(10, TimeUnit.SECONDS)){
            System.out.println("Something went wrong");
            service.shutdownNow();
        }
    }

    public void addKnight(Knight knight) {
        this.knightList.add(knight);
    }
}
