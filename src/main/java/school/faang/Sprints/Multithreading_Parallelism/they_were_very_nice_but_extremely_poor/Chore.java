package school.faang.Sprints.Multithreading_Parallelism.they_were_very_nice_but_extremely_poor;

import lombok.Getter;

@Getter
public class Chore implements Runnable{
    private String chore;

    public Chore(String chore){
        this.chore = chore;
    }

    @Override
    public void run(){
        Thread.currentThread().getName();
        //Thread.sleep();
    }
}
