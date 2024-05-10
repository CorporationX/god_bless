package faang.school.godbless.BJS2_4135.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DataCenter {
    private final List<Server> servers = new ArrayList<>();
}