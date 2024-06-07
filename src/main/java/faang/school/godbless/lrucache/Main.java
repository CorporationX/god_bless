package faang.school.godbless.lrucache;

import lombok.RequiredArgsConstructor;

import java.time.Clock;
import java.time.Instant;
import java.util.Optional;

@RequiredArgsConstructor
public class Main implements DataRepository {

    private final DataRepository repository;
    private final LRUCache<Integer, Data> lruCache;
    private final Clock clock;

    @Override
    public Data save(Data newData) {
        Data savedData = repository.save(newData);
        lruCache.put(savedData.getId(), savedData);
        return savedData;
    }

    @Override
    public Optional<Data> findById(Integer id) {
        return lruCache.get(id)
                .or(() -> repository.findById(id))
                .map(data -> {
                    data.setTimestamp(Instant.now(clock));
                    lruCache.put(id, data);
                    return data;
                });
    }

    public void printCacheState() {
        lruCache.forEach((key, value) -> System.out.println(String.format("ID: %s; значение: %s; время последнего обращения: %s", value.getId(), value.getValue(), value.getTimestamp())));
    }
}
