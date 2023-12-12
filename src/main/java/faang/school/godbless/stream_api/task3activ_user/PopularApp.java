package faang.school.godbless.stream_api.task3activ_user;



import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PopularApp {
//    public static void top10ActiveUsers(List<UserAction> actions) {
//        System.out.println("Топ 10 самых активных пользователей:");
//        List<String> names = actions.stream().
//                collect(Collectors.groupingBy(UserAction::getId)).
//                entrySet().stream().
//                sorted(Map.Entry.comparingByValue((val1, val2) -> Long.compare(val2.size(),
//                        val1.size()))).
//                limit(10).
//                map(en -> en.getValue().get(0).getName()).
//                distinct().
//                toList();
//        System.out.println(names);
//    }

    public static void top10ActiveUsers(List<UserAction> actions) {
        System.out.println("Топ-10 самых активных пользователей:");
        List<String> names = actions.stream().
                collect(Collectors.groupingBy(UserAction::getName, Collectors.counting())).
                entrySet().stream().
                sorted(Map.Entry.<String,Long>comparingByValue().reversed()).
                limit(10).
                map(Map.Entry::getKey).
                distinct().
                toList();
        System.out.println(names);
    }

    public static void top5Topics(List<UserAction> actions) {
        System.out.println("Топ-5 наиболее популярных тем обсуждения:");
        List<String> list = actions.stream().
                filter(action -> action.getContent() != null).
                flatMap(action -> Arrays.stream(action.getContent().split("\\s+"))).
                filter(word -> word.startsWith("#")).
                collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting())).
                entrySet().stream().
                sorted(Map.Entry.<String, Long> comparingByValue().reversed()).
                limit(5).
                map(Map.Entry::getKey).
                toList();
        System.out.println(list);
    }

    public static void top3ActiveCommentedUsers(List<UserAction> actions) {
        System.out.println("Tоп-3 пользователей, которые оставили наибольшее количество комментариев:");
        List<String> names = actions.stream().
                filter(act -> act.getActionType().equals("comment")).
                collect(Collectors.groupingBy(UserAction::getName, Collectors.counting())).
                entrySet().stream().
                sorted(Map.Entry.<String,Long>comparingByValue().reversed()).
                limit(10).
                map(Map.Entry::getKey).
                distinct().
                toList();
        System.out.println(names);
    }

    public PopularApp() {
        super();
    }

    public static void info(List<UserAction> actions) {
        System.out.println("Статистика:");
        int amountActions = actions.size();
        long amountComment = actions.stream().
                filter(act -> act.getActionType().equals("comment")).count();
        long amountPost = actions.stream().
                filter(act -> act.getActionType().equals("post")).count();
        long amountLike = actions.stream().
                filter(act -> act.getActionType().equals("like")).count();
        long amountShare = actions.stream().
                filter(act -> act.getActionType().equals("share")).count();
        System.out.println("Комментарии: " + Math.round((10000.0 * amountComment)/amountActions)/100.0 + "%");
        System.out.println("Посты: " + Math.round((10000.0 * amountPost)/amountActions)/100.0 + "%");
        System.out.println("Лайки: " + Math.round((10000.0 * amountLike)/amountActions)/100.0 + "%");
        System.out.println("Репосты: " + Math.round((10000.0 * amountShare)/amountActions)/100.0 + "%");
    }
}
