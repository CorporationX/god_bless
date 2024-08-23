package com.multitheading.tournament;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;

public class Knight {
    @Getter
    private String name;
    private List<Trial> trials = new ArrayList<>();

    public Knight(String name) {
        this.name = name;
    }

    public void addTrial(Trial trial) {
        Optional.of(trial).ifPresent(t -> trials.add(t));
    }

    public void startTrial(ExecutorService service) {
        for (Trial trial : trials) {
            service.submit(trial);
        }
    }
}
