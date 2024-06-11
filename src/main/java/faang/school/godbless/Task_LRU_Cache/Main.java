package faang.school.godbless.Task_LRU_Cache;

public class Main {

    public static void main(String[] args) {
        //check add
        LRU test = new LRU();
        test.addToLRU(2, new LRU.Data(2, 1, new LRU.Time(3,3)));
        test.addToLRU(3, new LRU.Data(2, 1, new LRU.Time(3,3)));
        test.addToLRU(4, new LRU.Data(2, 1, new LRU.Time(3,3)));
        test.addToLRU(5, new LRU.Data(2, 1, new LRU.Time(3,3)));
        test.showLRU();
        System.out.println();
        test.addToLRU(6, new LRU.Data(2, 1, new LRU.Time(3,3)));
        test.showLRU();
        System.out.println();
        test.addToLRU(7, new LRU.Data(2, 1, new LRU.Time(3,3)));
        test.showLRU();
        //check get
        System.out.println();
        test.getFromLRU(4);
        System.out.println();
        test.showLRU();
        System.out.println();
        test.getFromLRU(6);
        System.out.println();
        test.showLRU();
        //iteration with respect to time from oldest to newest and check both operations
        test.timeIteration();
        test.addToLRU(9, new LRU.Data(3,8, new LRU.Time(0,0)));
        test.timeIteration();
        test.getFromLRU(4);
        test.timeIteration();

    }

}
