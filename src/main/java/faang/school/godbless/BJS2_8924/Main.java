package faang.school.godbless.BJS2_8924;

public class Main {
    public static final Database database = new Database();
    private static final LRUChache lruCache = new LRUChache(15); // может быть любое число

    public String get(Integer key) {
        return lruCache.getData(key);
    }

    public void add(Integer key, String data) {
        lruCache.putData(key, data);
    }
}
