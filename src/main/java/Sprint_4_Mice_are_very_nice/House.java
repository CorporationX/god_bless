package Sprint_4_Mice_are_very_nice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//вопрос остался по корректной работе программы без synchronized в collectFood
//тк сейчас рабоает корректно только с synchronized :)

//цель: чтобы каждый поток собирал еду из своих комнат (например, 3 потока и 6 комнат)
//и чтобы все потоки заходили по одному разу в только в свою комнату.

@Data
public class House {
    List<Room> rooms;
    List<Food> food;

    public House(List<Room> rooms, List<Food> food) {
        this.rooms = rooms;
        this.food = food;
    }

    public synchronized void collectFood(Room room) {

        //for (int i = 0; i < rooms.size(); i++) {
        //цикл тут не нужен, тк каждый из 3х потоков, получил задание (по две комнаты каждому) прийти в этот метод и
        //сделать задания отсюда, то есть и без цикла каждыц поток придет сюда и выполнится.


        //food.addAll(room.getFoodForRoom());
        //если это сверху оставить - еда из всех комнат суммируется.
        //
        System.out.println(Thread.currentThread().getName() + ": " + room.getRoomName() + " Все фрукты получил " + room.getFoodForRoom());
        //здесь работают только потоки, метода main здесь нет, тк он отдал отправил в этот метод работать пул потоков.
        //System.out.println(Thread.currentThread().getName());
        room.setFoodForRoom(new ArrayList<>());
        System.out.println(Thread.currentThread().getName() + ": " + room.getRoomName() + " Фрукты собраны " + room.getFoodForRoom());
        //}
    }

    public static void main(String[] args) {

        List<Food> collectedFood = new ArrayList<>();
        Room room1 = new Room("кухня-1", List.of(new Food("фрукты"), new Food("авокадо")));
        Room room2 = new Room("гостинная-2", List.of(new Food("черри"), new Food("помидор"), new Food("нут")));
        Room room3 = new Room("прихожая-3", List.of(new Food("груша"), new Food("виноград"), new Food("чиа")));
        Room room4 = new Room("детская-4", List.of(new Food("чечевица"), new Food("бобы"), new Food("орехи")));
        Room room5 = new Room("взрослая-5", List.of(new Food("огурец"), new Food("ваниль"), new Food("черешня")));
        Room room6 = new Room("балкон-6", List.of(new Food("изюм"), new Food("банан"), new Food("свекла")));
        House house = new House(List.of(room1, room2, room3, room4, room5, room6), collectedFood);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);

        //for (int i = 0; i < 3; i++) {
        //цикл не нужен, тк путем synchronized потоки синхронизируются и каждый поток (всего 6 штук)
        //идет собирать еду из двух комнат. То есть у каждого потока из пула индивидуотное задание (индивидуальные две комнаты).

        //delay: 3_000 - это про то, что потоки (рабочие) приходят к своему заданию (к методу collectFood) и стоят ждут еще 3 сек
        //и потом начинают делать задание.

        executorService.schedule(() -> house.collectFood(room1), 3000, TimeUnit.MILLISECONDS);
        executorService.schedule(() -> house.collectFood(room2), 3000, TimeUnit.MILLISECONDS);
        executorService.schedule(() -> house.collectFood(room3), 3000, TimeUnit.MILLISECONDS);
        executorService.schedule(() -> house.collectFood(room4), 3000, TimeUnit.MILLISECONDS);
        executorService.schedule(() -> house.collectFood(room5), 3000, TimeUnit.MILLISECONDS);
        executorService.schedule(() -> house.collectFood(room6), 3000, TimeUnit.MILLISECONDS);
        //}

        executorService.shutdown();

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println(Thread.currentThread().getName());
        //awaitTermination main ждет пока потоки из пула закончат свою работу и потом продолжает свое дейсвтие и выводит фраузу
        //то емть даже если в awaitTermination написано 100 сек, это не очень важно, тк main продолжит работу как только пул
        //закончит свои дела, и main не будет ждать 100 сек , если потоки сдлеают дела за 2 сек, то main подождет только 2 сек и
        //пойдет выводить строку.
        //отличие awaitTermination от sleep в том, что sleep просто заставляет спать main и за это время потоки должны успеть
        //сделать свои дела, но если sleep длится 5 сек, а потоки сделали дела за 2 сек, то main еще будет простаивать 3 сек, что не очень хорошо.

        try {
            executorService.awaitTermination(100_000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //везде в программе кроме метода, где работают потоки (collectFood), работает метод main, где бы не вызывать имя работающего потока.
        System.out.println(Thread.currentThread().getName());

        System.out.println();
        System.out.println("Еда в доме (во всех комнатах) собрана!");
    }
}
