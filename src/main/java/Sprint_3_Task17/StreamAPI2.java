package Sprint_3_Task17;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamAPI2 {
    public static Map<Integer, Integer> API(List<Integer> integerList) {
        int a = 5;
        Map<Integer, Integer> map = new HashMap<>();
//        На вход дан список целых чисел и число. Найдите все уникальные пары чисел, сумма которых равна заданному числу.
        integerList.stream()
                .forEach(s -> {
                    if (integerList.contains(a - s)) {
                        int min = Math.min(s, a - s);
                        int max = Math.max(s, a - s);
                        map.put(min, max);
                    }
                });
        return map;
    }

    public static List<String> API2(Map<String, String> map) {
//        На вход получаем мапу с названиями стран и их столицами.
//        Отсортируйте страны по алфавиту, а затем выведите названия их столиц в виде списка.
        return map.entrySet().stream().
                sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> API3(List<String> list, char c) {
//        Получаем список строк и букву в виде char.
//        Отфильтруйте строки, которые начинаются с заданной буквы,
//        и отсортируйте их по длине в порядке возрастания, и верните список этих строк.
        return list.stream()
                .filter(s -> s.startsWith(String.valueOf(c)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static Map<String, String> API4(Map<String, List<String>> listMap) {
//        Дана мапа, где ключами являются имена людей, а значениями — списки их друзей.
//        Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья.
        Map<String, String> map = new HashMap<>();
        listMap.forEach((s1, listS1) -> {
            listMap.forEach((s2, listS2) -> {
                if (!(s1.equals(s2)) && !(listS1.contains(s2))) {
                    listS1.stream()
                            .filter(listS2::contains)
                            .findFirst()
                            .ifPresent(s -> {
                                if (!(map.containsKey(s2)) || !(map.get(s2).equals(s1))) {
                                    map.put(s1, s2);
                                }});
                }
            });
        });
        return map;
    }
    public static Map<String,Double> API5(List<Employee> employeeList){
//        Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел.
//        Найдите среднюю зарплату для каждого отдела. Должна получится map с именем отдела и средней зарплатой.

        Map<String, Double> result = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)));
        return result;
    }
    public static List<String> API6(String string,List<String> stringList){
//        Дан список строк. Отфильтруйте строки, которые содержат только буквы заданного алфавита,
//        и отсортируйте их в порядке возрастания длины строк.
        return stringList.stream()
                .filter(s -> s.matches("[a-zA-Z]*"))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
    public static List<String> API7(List<Integer> integerList){
//        Написать метод, который преобразует список целых чисел в список строк,
//        где каждое число записано в двоичном виде.
        return integerList.stream()
                .map(Integer::toBinaryString)
                .toList();

    }
    public static List<Integer> API8(int a, int b){
//        Написать метод, который найдет все числа-палиндромы
//        (читающиеся одинаково слева направо и справа налево) в заданном диапазоне.
//        На вход получаем число для начала диапазона и число для второй границы диапазона.
        return IntStream.range(a,b+1)
                .boxed()
                .map(Object::toString)
                .map(StringBuilder::new)
                .filter(s->{
                    String def = new String(s);
                    s.reverse();
                    return def.contentEquals(s);
                }).map(StringBuilder::toString)
                .map(Integer::valueOf)
                .toList();
    }
    public static List<String> API9(String str){
//        Доп задание: Написать метод, который найдёт все подстроки в строке, которые являются палиндромами.
//        На вход получаем строку, а вернуть должны список строк.
        return Arrays.stream(str.split(" "))
                .map(StringBuilder::new)
                .filter(s->{
                    String def = new String(s);
                    s.reverse();
                    return def.contentEquals(s);
                }).map(StringBuilder::toString)
                .toList();
    }
    public static void API10(){
//        Доп задание: Написать метод, который найдёт все совершенные числа
//        (сумма делителей числа равна самому числу) в заданном диапазоне.
//        На вход получаем число для начала диапазона и число для второй границы диапазона.

    }


    public static void main(String[] args) {

        String str = "madam I'm Adam ara madam";
        System.out.println(API9(str));


        int a = 33;
        int b = 88;
        System.out.println(API8(a,b));


        List<Integer> integerList2 = List.of(1,2,3,4,6);
        System.out.println(API7(integerList2));

        String s = "abcd";
        List<String> stringList1 = List.of("Nikita","Vlad","Никита");
        System.out.println(API6(s,stringList1));

        List<Employee> employeeList = List.of(
                new Employee("Nikita",100,"Moscow")
                ,new Employee("Vlad",200,"St.Ptr.")
                ,new Employee("Vlad2",200,"St.Ptr.")
                ,new Employee("Inna",300,"Moscow"));
        System.out.println(API5(employeeList));

        Map<String, List<String>> listMap = Map.of(
                "Коля",List.of("Влад","Инна"),
                "Никита", List.of("Инна"),
                "Петя", List.of("Влад"));
        System.out.println(API4(listMap));

        char c = 'N';
        List<String> stringList = List.of("dg", "Nikita", "Vlad");
        System.out.println(API3(stringList, c));

        Map<String, String> stringStringMap = Map.of("Россия", "Москва", "M", "f");
        System.out.println(API2(stringStringMap));

        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, -1); // 1+4 , 2+3, -1+6
        System.out.println(API(integerList));

    }
}
