package school.faang.task47701;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;


@Getter
public class Knight {
    private final String name;
    private final List<Trail> trails = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }


    public void addTrail(Trail trail) {

        trails.add(trail);
    }

    public void startTrails(ExecutorService executorService) {
        trails.forEach(executorService::submit);
    }
}


