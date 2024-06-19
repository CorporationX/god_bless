package faang.school.godbless.lru_cache;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@Slf4j
public class Database {
    private Map<Integer, Data> idDataMap;

    public Data getData(int id) {
        if (idDataMap.containsKey(id)) {
            return idDataMap.get(id);
        } else {
            throw new RuntimeException("Could not find data in database");
        }
    }
}
