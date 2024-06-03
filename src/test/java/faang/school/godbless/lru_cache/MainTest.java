package faang.school.godbless.lru_cache;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


//im too lazy to implement array return on cacheStatus so no assertions
class MainTest {
    @Test
    public void testGet() {
        System.out.println("************************************\n Test Null");
        Main main = new Main(1);
        assertNull(main.get(2));

    }

    @Test
    public void testOne() {
        System.out.println("************************************\n Test One value");
        Main main = new Main(1);
        main.put(new Data(2, "test", new Date()));
        assertEquals(2, main.get(2).id);
        assertArrayEquals(new int[]{2, 2, 2}, main.getCacheStatus());
    }

    @Test
    public void testPuts() {
        System.out.println("************************************\n Test Puts");
        Main main = new Main(2);
        for(int i = 0; i <= 4; i++) {
            main.put(new Data(i, "test", new Date()));
        }
        assertArrayEquals(new int[]{-1, -1, -1, -1}, main.getCacheStatus());
        main.get(2);
        main.get(3);
        assertArrayEquals(new int[]{3, 2, 2, 3}, main.getCacheStatus());;
        main.get(4);
        assertArrayEquals(new int[]{4, 3, 3, 4}, main.getCacheStatus());
        main.get(2);
        assertArrayEquals(new int[]{2, 4, 2, 4}, main.getCacheStatus());
    }

    @Test
    public void testPutsLarge() {
        System.out.println("************************************\n Test Puts Larger");
        Main main = new Main(3);
        for(int i = 0; i <= 7; i++) {
            main.put(new Data(i, "test", new Date()));
        }
        assertArrayEquals(new int[]{-1, -1, -1, -1, -1}, main.getCacheStatus());
        main.get(2);
        main.get(3);
        main.get(5);
        assertArrayEquals(new int[]{5, 2, 2, 3, 5}, main.getCacheStatus());
        main.get(4);
        main.get(2);
        assertArrayEquals(new int[]{2, 5, 2, 4, 5}, main.getCacheStatus());
    }

    @Test
    public void testPutsLargest() {
        System.out.println("************************************\n Test Puts Larger");
        Main main = new Main(3);
        for(int i = 0; i <= 7; i++) {
            main.put(new Data(i, "test", new Date()));
        }
        assertArrayEquals(new int[]{-1, -1, -1, -1, -1}, main.getCacheStatus());
        main.get(2);
        main.get(3);
        main.get(5);
        main.get(1);
        main.get(6);
        assertArrayEquals(new int[]{6, 5, 1, 5, 6}, main.getCacheStatus());
        main.get(4);
        main.get(1);
        main.get(1);
        main.get(2);
        assertArrayEquals(new int[]{2, 4, 1, 2, 4}, main.getCacheStatus());
    }

}