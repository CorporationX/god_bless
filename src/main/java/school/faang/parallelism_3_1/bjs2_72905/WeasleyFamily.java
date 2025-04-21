package school.faang.parallelism_3_1.bjs2_72905;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RequiredArgsConstructor
public class WeasleyFamily {
    static final List<Chore> chores = List.of(
            new Chore("помыть посуду"), new Chore("подмести пол"), new Chore("приготовить ужин"));

    public static void main(String[] args) {
        try (ExecutorService cachedThreadPool = Executors.newCachedThreadPool()) {
            chores.forEach(cachedThreadPool::execute);
        }
    }
}
