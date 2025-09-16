package school.faang.bjs2_91500;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Army {
    private final List<Squad> units = new ArrayList<>();

    public int calculateTotalPower() {
        CalculatePower calculatePower = new CalculatePower(units);
        Thread threadFirst = new Thread(calculatePower);
        Thread threadSecond = new Thread(calculatePower);
        Thread threadThird = new Thread(calculatePower);
        try {
            log.info("Запуск первого потока");
            threadFirst.start();
            log.info("Запуск второго потока");
            threadSecond.start();
            log.info("Запуск третьего потока");
            threadThird.start();
            threadFirst.join();
            threadSecond.join();
            threadThird.join();
        } catch (Exception e) {
            log.info("Ошибка в подсчете общей силы");
        }
        return calculatePower.getPower();
    }

    public void addSquad(Squad squad) {
        if (squad == null) {
            log.info("Ошибка в валидации, при рассчете силы новой группы {} - класс", getClass());
            throw new IllegalArgumentException("Группа не может быть пустой");
        }
        units.add(squad);
    }
}
