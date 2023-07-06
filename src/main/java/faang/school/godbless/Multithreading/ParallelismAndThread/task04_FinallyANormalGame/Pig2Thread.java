package faang.school.godbless.Multithreading.ParallelismAndThread.task04_FinallyANormalGame;

public class Pig2Thread extends PigThread{
    public Pig2Thread(String pigName, String material) {
        super(pigName, material);
    }
    public void buildHome(){
        super.buildHome(15000);
        System.out.println(getPigName() + " built a house out of " + getMaterial());
    }
}
