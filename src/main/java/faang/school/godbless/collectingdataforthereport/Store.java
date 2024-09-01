package faang.school.godbless.collectingdataforthereport;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Store {
    @Getter
    private final int storeId;
    private final Random random;

    public Store(int storeId) {
        this.storeId = storeId;
        this.random = new Random();
    }

    public List<Sales> generateSalesData() {
        List<Sales> salesList = new ArrayList<>();
        int numberOfSales = random.nextInt(10) + 1;
        for (int i = 0; i < numberOfSales; i++) {
            int productId = random.nextInt(100) + 1;
            int quantity = random.nextInt(20) + 1;
            salesList.add(new Sales(productId, LocalDateTime.now(), quantity));
        }
        return salesList;
    }
}