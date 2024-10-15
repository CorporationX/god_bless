package school.faang.theywerenice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<Chore> chores = getAllChores();

        ExecutorService service = Executors.newCachedThreadPool();

        for(Chore chore : chores){
            service.execute(chore);
        }

        service.shutdown();
    }

    public static List<Chore> getAllChores(){
        List<Chore> chores = new ArrayList<>();
        chores.add(new Chore("Помыть полы"));
        chores.add(new Chore("Помыть посуду"));
        chores.add(new Chore("Заправить кровать"));
        chores.add(new Chore("Вынести мусор"));
        chores.add(new Chore("Погулять с собакой"));
        chores.add(new Chore("Приготовить оборотное зелье"));
        chores.add(new Chore("Сделать уроки"));
        chores.add(new Chore("Убить Волландеморта"));

        return chores;
    }
}
