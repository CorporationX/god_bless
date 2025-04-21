package school.faang.stream3.weasleyfamily;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private static final List<Chore> TASK_LIST = new ArrayList<>();
    private static final int WEASLEY_FAMILY_MEMBERS_COUNT = 9;

    public static void main(String[] args) {

        List<String> tasksDescription = List.of(
                "уборка", "готовка", "стирка и починка одежды", "сборы в Хогвартс", "уход за домашними животными",
                "помощь в семейном бизнесе", "устранение магических последствий", "приём гостей", "уход за садом и " +
                        "огородом", "поддержание магических предметов в рабочем состоянии", "забота о детях",
                "контроль за домашним обучением до школы", "заготовка припасов", "ремонт дома заклинаниями",
                "проверка совиной почты", "создание и починка самодельных вещей", "участие в Ордена Феникса",
                "прятание опасных артефактов", "помощь соседям-маглам", "отпугивание гномов с огорода",
                "приготовление зелий для домашнего пользования", "уход за камином с летучим порохом", "наблюдение за " +
                        "детьми, летающими на мётлах", "успокаивание магических существ", "слежка за близнецами и их " +
                        "экспериментами", "шитьё и вязание вручную и магией", "чистка волшебных котлов и инвентаря",
                "помощь в праздниках и семейных мероприятиях", "распаковка и сортировка школьных вещей", "поддержка " +
                        "камуфляжа дома от маглов");
        for (String task : tasksDescription) {
            TASK_LIST.add(new Chore(task));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(WEASLEY_FAMILY_MEMBERS_COUNT);
        for (Chore task : TASK_LIST) {
            executorService.execute(task);
        }
        executorService.shutdown();
    }
}
