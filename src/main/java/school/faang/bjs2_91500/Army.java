package school.faang.bjs2_91500;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Army {
    private final List<Squad> squad = new ArrayList<>();

    public int calculateTotalPower() {
        int totalPower = 0;
        List<CalculatePower> taskCalculate = new ArrayList<>();
        List<Thread> threadList = new ArrayList<>();
        log.info("Запускаем потоки");
        for (int i = 0; i < squad.size(); i++) {
            Squad oneSquad = squad.get(i);
            CalculatePower calculatePower = new CalculatePower(oneSquad);
            Thread thread = new Thread(calculatePower);
            thread.start();
            threadList.add(thread);
            taskCalculate.add(calculatePower);
        }
        try {
            for (int i = 0; i < threadList.size(); i++) {
                Thread thread = threadList.get(i);
                thread.join();
                log.info("{} Общая сила для группы равна {}", thread.getName(), taskCalculate.get(i).getPower());
                totalPower += taskCalculate.get(i).getPower();
            }
        } catch (Exception e) {
            log.info("Ошибка в подсчете общей силы");
        }
        return totalPower;
    }

    public void addSquad(Squad squad) {
        if (squad == null) {
            log.info("Ошибка в валидации, при рассчете силы новой группы {} - класс", getClass());
            throw new IllegalArgumentException("Группа не может быть пустой");
        }
        this.squad.add(squad);
    }
}
