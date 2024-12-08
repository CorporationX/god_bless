package school.faang.task_45018;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class DataCenter {
    private final List<Server> dataCenters;
}