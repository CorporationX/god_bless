package school.faang.BJS2_61136;

import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class Army {

    private final List<Squad<? extends Warrior>> squadList;

    public Army(@NonNull List<Squad<? extends Warrior>> squadList) {
        this.squadList = squadList;
    }

    public int calculateTotalPower() {
        ExecutorService service = Executors.newFixedThreadPool(squadList.size());

        try {
            return squadList.stream()
                    .map(squad -> service.submit(squad::calculateSquadPower))
                    .mapToInt(future -> {
                        try {
                            return future.get();
                        } catch (InterruptedException | ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .sum();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            service.shutdown();
        }
    }
}
