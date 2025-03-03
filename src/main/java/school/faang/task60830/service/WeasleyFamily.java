package school.faang.task60830.service;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class WeasleyFamily {
    private List<Chore> tasks;

    public WeasleyFamily() {
        this.tasks = new ArrayList<>();
        tasks.add(new Chore("помыть посуду"));
        tasks.add(new Chore("подмести пол"));
        tasks.add(new Chore("приготовить ужин"));
    }

    public void addTask(Chore task) {
        tasks.add(task);
    }
}