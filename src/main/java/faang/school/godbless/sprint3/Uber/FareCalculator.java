package faang.school.godbless.sprint3.Uber;

public class FareCalculator {
    public double calculateFare(double dist,double time,BiFunction act){
        //за беспелатно машина не приедет...
        return act.count(dist,time)==0 ? 5 : act.count(dist,time);
    }
}
