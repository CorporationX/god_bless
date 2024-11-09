package school.faang.report;
import java.util.List;

public class salesdata {
    public String storeID;
    public List<sales> salesList;

    public salesdata(String sid, List<sales> slist) {
        storeID = sid;
        salesList = slist;
    }

    public String StoreID() {
        return storeID;
    }

    public List<sales> GetSalesList() {
        return salesList;
    }
}
