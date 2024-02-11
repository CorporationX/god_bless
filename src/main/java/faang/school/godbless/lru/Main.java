package faang.school.godbless.lru;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<Integer, Data> cache = new HashMap<>();
    private static final Map<Integer, Data> dataStructure = new HashMap<>();
    private static final int CACHE_SIZE = 1;

    public static void main(String[] args) {
        Data data1 = new Data( 1, "Value 1", System.currentTimeMillis() - 1000 );
        Data data2 = new Data( 2, "Value 2", System.currentTimeMillis() - 500 );
        Data data3 = new Data( 3, "Value 3", System.currentTimeMillis() - 300 );
        Data data4 = new Data( 4, "Value 4", System.currentTimeMillis() );

        dataStructure.put( data1.getId(), data1 );
        dataStructure.put( data2.getId(), data2 );
        dataStructure.put( data3.getId(), data3 );

        Main.addData( data1 );
        Main.addData( data2 );
        printCache( cache );
        Main.addData( data3 );
        System.out.println( "**********************************************************************" );
        printCache( cache );
        System.out.println(getDataById(2));
    }
    public static void addData(Data data) {
        if (cache.size() > CACHE_SIZE) {
            removeOldestData();
        }
        cache.put( data.getId(), new Data( data.getId(), data.getValue(), data.getTimeStamp() ) );
    }
    public static Data getDataById(int id) {
        Data data = cache.get( id );
        if (data != null) {
            data.setTimeStamp( System.currentTimeMillis() );
            return data;
        } else {
            Data d = dataStructure.get(id);
            if (d != null) {
                cache.put( id, new Data( id, data.getValue(), System.currentTimeMillis() ) );
                addData( d );
                return d;
            } else {
                return null;
            }
        }
    }
    private static void removeOldestData() {
        long min = Long.MAX_VALUE;
        int i = 0;
        for (int id : cache.keySet()) {
            Data data = cache.get( id );
            long timeStamp = data.getTimeStamp();
            if (timeStamp < min) {
                min = timeStamp;
                i = id;
            }
        }
        cache.remove( i );
    }
    public static void printCache(Map<Integer, Data> cache) {
        cache.forEach( (key, value) -> System.out.println( key + " " + value ) );
    }
}
