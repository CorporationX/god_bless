package faang.school.godbless.lruCache;

import java.util.Optional;

public interface CacheRepository {

    Optional<Data> create(Data data);

    Data get(Integer id);
}
