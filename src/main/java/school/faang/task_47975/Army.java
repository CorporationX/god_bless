package school.faang.task_47975;

import lombok.*;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Army {
    private List<Archer> archer;
    private List<Knight> knight;
    private List<Mage> mage;
    private List<Swordsman> swordsman;


    @SneakyThrows
    public int calculateTotalPower() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<Integer> submit1 = executorService.submit(() -> archer.stream()
                .mapToInt(Archer::getPower).sum());
        Future<Integer> submit2 = executorService.submit(() -> knight.stream()
                .mapToInt(Knight::getPower).sum());
        Future<Integer> submit3 = executorService.submit(() -> mage.stream()
                .mapToInt(Mage::getPower).sum());
        Future<Integer> submit4 = executorService.submit(() -> swordsman.stream()
                .mapToInt(Swordsman::getPower).sum());

        Integer first = submit1.get();
        Integer second = submit2.get();
        Integer third = submit3.get();
        Integer fourth = submit4.get();
        return first+second+third+fourth;

    }
}
