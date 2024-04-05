package faang.school.godbless.javaHashMap.LRU_Cache;

public class Main {

    public static void main(String[] args) {
        DataService dataService = new DataService();
        Cache lruCache = new Cache(dataService);

        System.out.println("LRU Cache at start point:");
        lruCache.printCache();

        System.out.println("\n---------------------------------");

        System.out.println("\nGetting 10 (MAX_SIZE = 10) records of data:");

        System.out.println(lruCache.getData(1));
        System.out.println(lruCache.getData(2));
        System.out.println(lruCache.getData(3));
        System.out.println(lruCache.getData(4));
        System.out.println(lruCache.getData(5));
        System.out.println(lruCache.getData(6));
        System.out.println(lruCache.getData(7));
        System.out.println(lruCache.getData(8));
        System.out.println(lruCache.getData(9));
        System.out.println(lruCache.getData(10));

        System.out.println("\n---------------------------------");

        System.out.println("\nLRU Cache at this point:\"");
        lruCache.printCache();

        System.out.println("\n---------------------------------");

        System.out.println("\nGetting 4 (MAX_SIZE = 10) records of data:");

        System.out.println(lruCache.getData(1));
        System.out.println(lruCache.getData(2));
        System.out.println(lruCache.getData(11));
        System.out.println(lruCache.getData(12));

        System.out.println("\n---------------------------------");

        System.out.println("\nLRU Cache at this point:\"");
        lruCache.printCache();
    }


}
