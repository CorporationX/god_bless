package Microsoft;

public class SanderRunnable implements Runnable{
    private int startindex;
    private int endindex;

    public SanderRunnable(int startindex, int endindex) {
        this.startindex = startindex;
        this.endindex = endindex;
    }

    public int getStartindex() {
        return startindex;
    }

    public int getEndindex() {
        return endindex;
    }

    @Override
    public void run (){
        System.out.println("letter sent ");
    }
}
