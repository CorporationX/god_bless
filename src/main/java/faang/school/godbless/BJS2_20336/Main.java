package faang.school.godbless.BJS2_20336;

public class Main {
    public static void main(String[] args) {
        LruCacheService service = new LruCacheService();
        service.put(1, new Data(1, "Java"));
        service.put(2, new Data(2, "Python"));
        service.put(3, new Data(3, "C++"));
        service.put(4, new Data(4, "C#"));
        service.put(5, new Data(5, "Kotlin"));
        service.put(6, new Data(6, "Go"));

        service.printCache();
        System.out.println();

        System.out.println(service.get(5).get());
        service.printCache();
        System.out.println();

        System.out.println(service.get(1).get());
        service.printCache();
        System.out.println();
    }
}
