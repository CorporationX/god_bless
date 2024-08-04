package faang.school.godbless.DataCenter;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class DataCenter {
    private final List<Server> SERVERS = new ArrayList<>();
}
