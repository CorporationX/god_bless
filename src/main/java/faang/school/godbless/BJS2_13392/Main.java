package faang.school.godbless.BJS2_13392;

import java.util.concurrent.ExecutionException;

import static faang.school.godbless.BJS2_13392.MasterCardService.doAll;

public class Main {
    public static void main(String[] args){
        try{
            doAll();
        } catch (ExecutionException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
