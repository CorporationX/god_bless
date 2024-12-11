package school.faang.task_45018;

import java.util.ArrayList;
import java.util.List;

public class DataInitializerUtils {
    public static List<Server> initDataCenter() {
        List<Server> arrayList = new ArrayList<>();
        arrayList.add(new Server(1, 5, 10));
        arrayList.add(new Server(2, 4, 2));
        arrayList.add(new Server(2, 4, 2));
        arrayList.add(new Server(5, 5, 2));
        return arrayList;
    }
}