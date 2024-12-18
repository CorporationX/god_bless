package school.faang.sprint_1.task_theverynicebjs2n48398;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
@AllArgsConstructor
public class WeasleyFamily {
    @NonNull
    private Chore[] chores;

    public void executeChores() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (Chore chore : chores) {
            executorService.submit(chore);
        }
    }

    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily(new Chore[]{
                new Chore("помыть посуду"),
                new Chore("подмести пол"),
                new Chore("приготовить ужин"),
                new Chore("приготовить ужин быстрее!"),
                new Chore("Купить оливки на Новый год"),
                new Chore("Оплатить за отопление"),
                new Chore("Поспать"),
                new Chore("Накормить кота"),
                new Chore("Навести порядок в зале"),
                new Chore("Купит мандарины на Новый год"),
                new Chore("Постоять в углу за мандарины")
        }
        );
        weasleyFamily.executeChores();
    }
}
