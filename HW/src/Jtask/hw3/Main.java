package Jtask.hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.*;

class LicensePlateValidator {
    // те коды что можно использовать
    public static final Map<String, String> regeons = new HashMap<String, String>(){{
        put("777", "Москва");
        put("77", "Москва");
        put("761", "Самара");
        put("61", "Самара");
        put("18", "Ижевск");
        put("118", "Ижевск");
    }};

    // Регулярное выражение для проверки номеров автомобилей
    //TODO: ограничимся на только на RUS
    private static final String LICENSE_PLATE_REGEX = "([АВЕКМНОРСТУХABEKMHOPCTYX]\\d{3}[АВЕКМНОРСТУХABEKMHOPCTYX]{2})(RUS)?(\\d{2,3})";

    public static boolean isValid(String licensePlate) {

        Matcher matcher = Pattern.compile(LICENSE_PLATE_REGEX).matcher(licensePlate);

        // проверка на валидность номера, кроме проверки числового региона
        if(matcher.matches()) {
            //проверка числового региона
            return matcher.groupCount() == 3 ? defineReg(matcher.group(3)) : defineReg(matcher.group(2));
        } else {
            return false;
        }
    }

    private static boolean defineReg(String group) {
       if(regeons.containsKey(group)) {
           System.out.println("Регион: " + regeons.get(group));
           return true;
       } else {
           System.out.println("Неверный регион: " + group);
           return false;
       }
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите номер автомобиля (для выхода введите 'exit'): ");
            String input = scanner.nextLine().toUpperCase().replaceAll(" ", "");

            if (input.equals("EXIT")) {
                System.out.println("Программа завершена.");
                break;
            }

            if (!LicensePlateValidator.isValid(input)) {
                System.out.println("По некоторым причинам ваш номер автомобиля не валиден, набор причин представлен ниже :) ");
                System.out.println("- Возможно длина не та");
                System.out.println("- Возможно символы не те");
                System.out.println("- Возможно вы пытаетесь намеренно ввести что-то другое");
                continue;
            } else {
                System.out.println("Всё здесь верно: " + input);
            }

        }
    }
}