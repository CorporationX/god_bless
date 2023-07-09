package faang.school;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
@AllArgsConstructor
public class DataCollector extends Thread{
    private CountDownLatch latch;
    private SalesData salesData;

    public List<Sale> fetchSalesFromStore(){
        return new ArrayList<>();
    }
    @Override
    public void run() {
        latch.countDown();
    }
}
