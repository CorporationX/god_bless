package school.faang.naughtwoBJS260797;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class WeasleyFamily {
    public static void main(String[] args) {
        Chore[] chores = addChores();
        ExecutorService executor = Executors.newCachedThreadPool();
        for (Chore chore : chores){
            executor.execute(chore);
        }
        executor.shutdown();
        log.debug("The work is done");
    }

    private static Chore[] addChores() {
        return new Chore[]{new Chore("wash dishes"),
                new Chore("sweep the floor"),
                new Chore("cook dinner"),
                new Chore("wash clothes"),
                new Chore("clean the room"),
                new Chore("feed the pets"),
                new Chore("do homework"),
                new Chore("take out the trash"),
                new Chore("weed the garden"),
                new Chore("go to the store"),
                new Chore("shovel snow from the path"),
                new Chore("iron clothes"),
                new Chore("clean the garage"),
                new Chore("wipe the windows"),
                new Chore("walk the dog"),
                new Chore("start an expense record"),
                new Chore("make breakfast"),
                new Chore("do homework"),
                new Chore("put things back"),
                new Chore("check mail")};
    }
}

