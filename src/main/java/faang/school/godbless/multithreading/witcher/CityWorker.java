package faang.school.godbless.multithreading.witcher;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {

    private City city;

    private List<Monster> monsters;

    // сколько монстров возле города
    public List<Monster> findNearestMonster(City city, List<Monster> monsters) {
        return monsters.stream().filter(m -> m.nearCity().equals(city)).limit(1).toList();
    }

    public void waitKill(int killTime) throws InterruptedException {
        Thread.sleep(killTime * 1000L);
    }


    public long getJourneyDistance(City city) {
        return city.distance();
    }

    @Override
    public void run() {
        List<Monster> monsterNear = findNearestMonster(city, monsters);

        int sumKillTime = monsterNear.stream().mapToInt(Monster::getKillTime).sum();

        try {
            waitKill(sumKillTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Город: " + city.name());

        System.out.println("Количество монстров " + monsterNear.size());

        System.out.println("Время на убийство " + sumKillTime + " часа");

        System.out.println("Дистанция до города " + getJourneyDistance(city) + " км." + "\n");
    }
}
