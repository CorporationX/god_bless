package faang.school.godbless.superheroes.battle;

import ch.qos.logback.core.joran.sanity.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SuperheroBattle {
   public List<Future<Superhero>> runCompetitions(List<MyPair<Superhero, Superhero>> list) {
      ExecutorService executor = Executors.newFixedThreadPool(list.size());

      List<Future<Superhero>> futureList = new ArrayList<>();
      for (MyPair<Superhero, Superhero> superhero : list) {
         if (superhero.getFirst().getStrength() > superhero.getSecond().getStrength()) {
            futureList.add(executor.submit(() -> superhero.getFirst()));
         }
         if (superhero.getFirst().getStrength() < superhero.getSecond().getStrength()) {
            futureList.add(executor.submit(() -> superhero.getSecond()));
         }
      }
      executor.shutdown();
      return futureList;
   }
}
