package school.faang.Sprints.Multithreading_Async.asynchrony_and_future;

public class Main {
    public static void main(String[] args){
        MasterCardService service = new MasterCardService();
        service.doAll();
    }

}