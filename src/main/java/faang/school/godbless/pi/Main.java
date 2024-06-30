package faang.school.godbless.pi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        calculatePi(500);
    }
    static boolean isInside(double x,double y){
        double radius = 1.0;
        return x * x + y * y <= radius * radius;
    }
    static double calculatePi(int n) throws ExecutionException, InterruptedException {
        NumberGenerator generator = new NumberGenerator();
        IntStream loop = IntStream.range(1,n);
        List<CompletableFuture<Point>> futures = new ArrayList<>();
        AtomicInteger all = new AtomicInteger(0);
        AtomicInteger inside = new AtomicInteger(0);
        loop.forEach(item->{
            CompletableFuture<Point> thread = CompletableFuture.supplyAsync(()->{
                double x = generator.generate();
                double y = generator.generate();
                System.out.println("point is "+x);
                return new Point(x,y);
            }).thenApply((point -> {
                if(isInside(point.getX(),point.getY())) {
                    inside.accumulateAndGet(1,Integer::sum);
                } else {
                    all.accumulateAndGet(1,Integer::sum);
                }
                return point;
            }));
            futures.add(thread);
        });
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.get();
        System.out.println("all "+all.intValue());
        System.out.println("inside "+inside.intValue());
        Double result = 4.0 * inside.intValue()/all.intValue();
        System.out.println("result is "+result);
        return result;
    }
}
