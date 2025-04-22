//package school.faang.stream3.parallelismthread.distributedarmyofheroes;
//
//import lombok.Data;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//
//@Data
//public class Army{
//    private List<Squad> armyList = new ArrayList<>();
//
//    public int calculateTotalPower(){
//        int totalPower = 0;
//        ExecutorService executor = Executors.newFixedThreadPool(armyList.size());
//        List<Future<Integer>> futures = new ArrayList<>();
//
//        for (int i = 0; i < armyList.size(); i++) {
//            final int index = i;
//            futures.add(executor.submit(() -> armyList.get(index).calculateSquadPower()));
//        }
//
//        for (Future<Integer> future: futures){
//            try {
//                totalPower += future.get();
//            }
//            catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        return totalPower;
//    }
//
//    public void addSquad(Squad<? extends GameCharacter> squad) {
//        armyList.add(squad);
//    }
//}
