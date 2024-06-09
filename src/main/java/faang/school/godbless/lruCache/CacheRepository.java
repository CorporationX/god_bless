package faang.school.godbless.lruCache;

public interface CacheRepository {

    Data create(Data data);

    Data get(Integer id);
}
