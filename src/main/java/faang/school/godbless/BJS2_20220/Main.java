package faang.school.godbless.BJS2_20220;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class Main {
    private Map<Integer, DaTa> daTaMap = new HashMap<>();
    private Cache cache = new Cache(CACHE_SIZE);
    private static final int CACHE_SIZE = 3;

    public void addDaTa(DaTa daTa) {
        daTaMap.put(daTa.getId(), daTa);
    }

    public DaTa getDaTaById(Integer id) {
        DaTa daTa = cache.get(id);
        if (daTa == null) {
            daTa = daTaMap.get(id);
        }
        if (daTa != null) {
            daTa = new DaTa(daTa.getId(), daTa.getValue(), LocalDateTime.now());
            cache.put(id, daTa);
        }
        return daTa;
    }

    public void printCache() {
        for (Map.Entry<Integer, DaTa> entryCache : cache.entrySet()) {
            DaTa daTa = entryCache.getValue();
            System.out.println("Айди: " + daTa.getId() + ", значение данных: " + daTa.getValue() + ", время последнего обращения: " + daTa.getTimestamp());
        }
    }
}
