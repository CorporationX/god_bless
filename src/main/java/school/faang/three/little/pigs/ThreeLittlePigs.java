package school.faang.three.little.pigs;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ThreeLittlePigs {
    public static void main(String[] args) {
        PigThread nifNif = new PigThread("Ниф-Ниф", "Солома");
        PigThread nufNuf = new PigThread("Нуф-Нуф", "Дерево");
        PigThread nafNaf = new PigThread("Наф-Наф", "Кирпич");
        List<PigThread> pigThreads = new ArrayList<>(List.of(nifNif, nufNuf, nafNaf));

        pigThreads.forEach(PigThread::run);
        for (PigThread pigThread : pigThreads) {
            try {
                pigThread.join();
            } catch (InterruptedException e) {
                log.error("Поросенок " + pigThread.getPigName() + " не смог построить себе дома" + e.getMessage());
                e.printStackTrace();
            }
        }
        System.out.println("Игра завершена!");
    }
}
