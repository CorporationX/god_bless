package school.faang.task45030.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DataCenter {
    private final List<Server> serverList = new ArrayList<>();
}
