package org.example.service.theyWereVeryNiceButExtremelyPoor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.model.theyWereVeryNiceButExtremelyPoor.Chore;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
@AllArgsConstructor
public class WeasleyFamily {
    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private List<Chore> works;

    public void addChore(Chore chore) {
        works.add(chore);
    }

    public void gettingStartTheWorks(List<Chore> chores) {
        chores.forEach(executorService::submit);
        executorService.shutdown();
    }
}
