package faang.school.godbless.BJS2_19415;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


public class DataCenter {
    @Getter
    private List<Server> cluster = new ArrayList<>();

    public int getServersQuantity() {
        return cluster.size();
    }
}
