package faang.school.godbless.BJS2_24050;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {
                "Убраться в комнате",
                "Помыть посуду",
                "Почистить холодильник",
                "Сделать стирку",
                "Пропылесосить ковры",
                "Приготовить ужин",
                "Вытереть пыль",
                "Вывести мусор",
                "Полить растения",
                "Погладить одежду",
                "Помыть окна",
                "Починить кран",
                "Приготовить завтрак",
                "Организовать документы",
                "Убрать игрушки",
                "Обновить запасы продуктов",
                "Поменять постельное белье",
                "Провести уборку в ванной",
                "Почистить плиту",
                "Провести генеральную уборку"
        };
        ExecutorService executor = Executors.newCachedThreadPool();
        Arrays.stream(chores).forEach(chore -> executor.execute(new Chore(chore)));
        executor.shutdown();
    }
}
