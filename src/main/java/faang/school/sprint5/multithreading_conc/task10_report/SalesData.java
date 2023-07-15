package faang.school.sprint5.multithreading_conc.task10_report;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SalesData {

    private final int id;

    private final List<Sales> sales = new ArrayList<>();

    public SalesData(int id) {
        this.id = id;
    }

    public void addSales(Sales sales){
        this.sales.add(sales);
    }
}
