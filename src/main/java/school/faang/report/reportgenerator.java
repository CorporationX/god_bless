package school.faang.report;
import java.util.List;

public class reportgenerator {
    public List<salesdata> SalesDataList;

    public reportgenerator(List<salesdata> list) {
        SalesDataList = list;
    }

    public void GenerateReport() {
        System.out.println("Sales Report:");
        for (salesdata data : SalesDataList) {
            System.out.println("Store: " + data.StoreID());
            for (sales sale : data.GetSalesList()) {
                System.out.println("Product: " + sale.getID() +
                        ", Time: " + sale.Time() +
                        ", Quantity: " + sale.getQty());
            }
        }
    }
}
