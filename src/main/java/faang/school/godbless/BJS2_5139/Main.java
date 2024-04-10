package faang.school.godbless.BJS2_5139;

public class Main {
    public static void main(String[] args) {
        System.out.println("Сумма чётных чисел: " + StreamAPIService.findSumOfEvenNumbers());
        System.out.println("Максимальное число: " + StreamAPIService.findMaxNumber());
        System.out.println("Среднее значение: " + StreamAPIService.findAverageValueOfNumbers());
        System.out.println("Количество строк, которые начинаются с 's' : " + StreamAPIService
                .countStringStartingWithChar('s'));
        System.out.println("Слова содержащие подстроку: " + StreamAPIService.filterStringThatContainSubstring("si"));
        System.out.println("Отсортированный список: " + StreamAPIService.sortStringByLength());
        System.out.println("Элементы удовлетворяющие условию:" + StreamAPIService.checkStringForMaxLength(3));
        System.out.println("Минимальный элемент который больше 2: " + StreamAPIService.findMinElementThatMoreNumber(2));
        System.out.println("Длина строк:" + StreamAPIService.convertStringToStringLength());
    }
}
