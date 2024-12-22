package school.faang.task_48483;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {
                "помыть посуду",
                "подмести пол",
                "приготовить ужин",
                "постирать белье",
                "убрать в комнате",
                "сходить в магазин",
                "пропылесосить",
                "помыть окна",
                "выбросить мусор",
                "приготовить завтрак",
                "помыть машину",
                "проверить почту",
                "убрать игрушки",
                "посадить цветы",
                "погладить одежду"
        };
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (String ch : chores) {
            executorService.execute(() -> new Chore(ch).run());
        }
        executorService.shutdown();
    }
}
