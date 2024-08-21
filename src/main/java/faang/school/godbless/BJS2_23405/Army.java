package faang.school.godbless.BJS2_23405;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public class Army {
    private final Map<String, List<Character>> army = new HashMap<>();
    private final AtomicInteger totalPower = new AtomicInteger(0);

    public void addCharacter(Character character) {
        //распределение героев по типам
        army.computeIfAbsent(character.getClass().getSimpleName(), key -> new ArrayList<>()).add(character);
    }

    public int calculateTotalPower() {
        //создание потоков
        List<Thread> threads = army.values().stream()
                .map(this::createTask)
                .map(Thread::new)
                .toList();

        //одновременный запуск
        threads.forEach(Thread::start);

        //ожидаем, когда все потоки выполнятся
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread error");
            }
        });
        //возвращаем общую силу армии
        return totalPower.get();
    }

    private Runnable createTask(List<Character> characters) {
        return () -> {
            System.out.println("Start: " + Thread.currentThread().getName() + ": " + characters.get(0).getClass().getSimpleName());
            //поток считает сумму сил его героев
            int localTotalPower = characters.stream()
                    .map(Character::getPower)
                    .reduce(Integer::sum)
                    .orElseThrow();
            System.out.println("End: " + Thread.currentThread().getName() + ": " + characters.get(0).getClass().getSimpleName() + " -> Power: " + localTotalPower);
            //добавляем значение к общей сумме
            totalPower.addAndGet(localTotalPower);
        };
    }
}