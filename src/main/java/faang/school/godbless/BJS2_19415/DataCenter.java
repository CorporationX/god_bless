package faang.school.godbless.BJS2_19415;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class DataCenter {
    @Getter
    private Set<Server> cluster = new HashSet<>();
}
