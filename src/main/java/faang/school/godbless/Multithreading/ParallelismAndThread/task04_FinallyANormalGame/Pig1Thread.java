package faang.school.godbless.Multithreading.ParallelismAndThread.task04_FinallyANormalGame;

public class Pig1Thread extends PigThread{
    public Pig1Thread(String pigName, String material) {
        super(pigName, material);
    }
    public void buildHome(){
        super.buildHome(10000);
        System.out.println(getPigName() + " built a house out of " + getMaterial());
    }
}
