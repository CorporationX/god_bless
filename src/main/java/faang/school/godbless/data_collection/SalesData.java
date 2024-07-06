package faang.school.godbless.data_collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
@AllArgsConstructor
public class SalesData {
    private final Map<Integer, Sales> salesMap = new ConcurrentHashMap<>();

    private int salasDataId;
}
