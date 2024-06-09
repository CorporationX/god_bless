package faang.school.godbless.lruCache;

public interface CacheService {

    Data create(Integer id, String value);

    Data get(Integer id);
}
