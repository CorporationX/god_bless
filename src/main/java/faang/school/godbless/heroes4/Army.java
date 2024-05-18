package faang.school.godbless.heroes4;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Army extends Thread {
    private List<Army> units = new ArrayList<>();

    public void addUnit(Army army) {
        units.add(army);
    }

//    public Integer calculateTotalPower() throws ExecutionException, InterruptedException {
//        ExecutorService executor = Executors.newCachedThreadPool();
//        try {
//            List<Future<Result>> results = executor.invokeAll(units);
//            int totalPower = 0;
//            for (Future<Result> future : results) {
//                totalPower += future.get().p
//            }
//        }
//        finally {
//            executor.shutdown();
//        }
//
//        return totalPower;
//    }
}
