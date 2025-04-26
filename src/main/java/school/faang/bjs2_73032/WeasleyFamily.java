package school.faang.bjs2_73032;

import lombok.Data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
public class WeasleyFamily {

    private Chore[] toDo = {new Chore("Catch Frogs"),
            new Chore("Wipe Floors"),
            new Chore("Feed Rat"),
            new Chore("Get Harry off my sister"),
            new Chore("Borrow money from Harry never to return them"),
    };

    private ExecutorService executorService = Executors.newCachedThreadPool();
}
