package faang.school.godbless.DataCollectionForTheReport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class DataCollector extends Thread {
    List<SalesData> salesDataList;

    public List<SalesData> fetchSalesFromStore() {
        return salesDataList;
    }
}
