package faang.school.godbless.DataCollectionForTheReport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesData {
    private int id;
    private List<Sales> salesList;

    public SalesData(int id) {
        this.id = id;
        this.salesList = new ArrayList<>();
    }
}
