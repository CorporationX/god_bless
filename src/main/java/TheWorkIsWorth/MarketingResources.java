package TheWorkIsWorth;

import java.util.ArrayList;
import java.util.List;

public class MarketingResources {
    private List<String> marketingList = new ArrayList<>();

    public synchronized void readMarketingList() {
        for (String list : marketingList) {
            System.out.println(list);
        }
    }

    public synchronized void addMarketing(String marketing) {
        marketingList.add(marketing);
    }
}
