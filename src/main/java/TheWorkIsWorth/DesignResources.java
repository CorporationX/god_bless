package TheWorkIsWorth;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DesignResources {
    private List<String> designList = new ArrayList<>();

    public synchronized void readDesignList() {
        for (String list : designList) {
            System.out.println(list);
        }
    }

    public synchronized void addDesign(String design) {
        designList.add(design);
    }
}
