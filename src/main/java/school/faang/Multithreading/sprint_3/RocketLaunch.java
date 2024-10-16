package school.faang.Multithreading.sprint_3;

import java.util.List;

public class RocketLaunch {
    private final String name;
    private final int launchTime;

    public RocketLaunch(String name, int launchTime){
        validateParameters(name, launchTime);

        this.name = name;
        this.launchTime = launchTime;
    }

    private void validateParameters(String name, int launchTime){
        if(name.isEmpty() || name.isBlank()){
            throw new IllegalArgumentException("Ракета без имени");
        }else if(launchTime < 0){
            throw new IllegalArgumentException("Некорректное время запуска");
        }
    }

    public void launch() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Ракета" + name + "Запускается");
    }

    public void planRocketLaunches(List<RocketLaunch> launches){

    }

}
