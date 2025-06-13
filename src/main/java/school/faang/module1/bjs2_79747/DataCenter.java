package school.faang.module1.bjs2_79747;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataCenter {
    private final List<Server> servers = new ArrayList<>();
}