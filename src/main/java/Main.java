import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        numbers.add(2);
        numbers.add(-4);
        numbers.add(3);
        numbers.add(123);
        numbers.add(9);
        numbers.add(-56);


        Map<String, String> countries = new HashMap<>();
        countries.put("Algeria", "Algiers");
        countries.put("Turkey", "Ankara");
        countries.put("Madagascar", "Antananarivo");
        countries.put("Russia", "Moscow");

        System.out.println(sortCountriesReturnCapitals(countries));


        List<String> strings = new ArrayList<>();
        strings.add("asdf");
        strings.add("hello");
        strings.add("abdf");
        strings.add("");
        strings.add("bcde");

        System.out.println(filterByCharAndDescSort(strings, 'a'));




        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", "Coders", 1000));
        employees.add(new Employee("Tom", "Counters", 500));
        employees.add(new Employee("Bob", "Counters", 700));
        employees.add(new Employee("Ron", "Marketing", 1500));
        employees.add(new Employee("Tom", "Marketing", 1000));

        System.out.println(findDepartmentSalaryMap(employees));

    }

//    На вход дан список целых чисел и число. Найдите все уникальные пары чисел, сумма которых равна заданному числу.
//public static Map<Integer, Integer> findPairs(List<Integer> numbers){
//
//}

//    На вход получаем мапу с названиями стран и их столицами.
//    Отсортируйте страны по алфавиту, а затем выведите названия их столиц в виде списка.
    public static List<String> sortCountriesReturnCapitals(Map<String, String> countries){
        return countries.entrySet().stream().sorted((entry1, entry2) -> entry1.getKey().compareTo(entry2.getKey()))
                .map(entry -> entry.getValue()).toList();
    }

//    Получаем список строк и букву в виде char.
//    Отфильтруйте строки, которые начинаются с заданной буквы, и отсортируйте их по длине в порядке возрастания,
//    и верните список этих строк.
    public static List<String> filterByCharAndDescSort(List<String> strings, char startChar){
        return strings.stream().filter((string) -> string.startsWith(String.valueOf(startChar))).sorted(String::compareTo).toList();
    }

//    Дана мапа, где ключами являются имена людей, а значениями — списки их друзей.
//    Найдите все пары людей, которые не являются друзьями, но у них есть общие друзья.


//    Получаем список объектов класса Employee, у каждого из которых есть имя, зарплата и отдел.
//    Найдите среднюю зарплату для каждого отдела.
//    Должна получится map с именем отдела и средней зарплатой.
    public static Map<String, Integer> findDepartmentSalaryMap(List<Employee> employees){
        //создать мапу с отделами и листом зарплат
        Map<String, List<Integer>> salarysMap = new HashMap<>();
        Map<String, Integer> finalMap = new HashMap<>();
        //добавим ключи в мапу
        employees.stream().forEach(employee -> salarysMap.put(employee.getDepartment(), new ArrayList<>()));
        employees.stream().forEach(employee -> salarysMap.get(employee.getDepartment()).add(employee.getSalary()));

        salarysMap.entrySet().stream().forEach(entry -> finalMap.put(entry.getKey(), entry.getValue()
                .stream().reduce(0, (sum, salary) -> sum + salary)));


       return finalMap;
    }

//    Дан список строк. Отфильтруйте строки, которые содержат только буквы заданного алфавита, и отсортируйте их в порядке возрастания длины строк.
//
//    Написать метод, который преобразует список целых чисел в список строк, где каждое число записано в двоичном виде.
//
//    Написать метод, который найдет все числа-палиндромы (читающиеся одинаково слева направо и справа налево) в заданном диапазоне. На вход получаем число для начала диапазона и число для второй границы диапазона.
//
//    Доп задание: Написать метод, который найдёт все подстроки в строке, которые являются палиндромами. На вход получаем строку, а вернуть должны список строк.
//
//    Доп задание: Написать метод, который найдёт все совершенные числа (сумма делителей числа равна самому числу) в заданном диапазоне. На вход получаем число для начала диапазона и число для второй границы диапазона.

}
