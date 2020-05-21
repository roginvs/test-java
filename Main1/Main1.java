package Main1;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Main1 {

    /**
     * Returns array of DAY_OF_WEEK according to current startingDay
     */
    private static int[] getDaysLoop(int startingDay) {
        // Too lazy to calculate, easier to hardcode
        int[] numbers1 = { 1, 2, 3, 4, 5, 6, 7 };
        int[] numbers2 = { 2, 3, 4, 5, 6, 7, 1 };
        int[] numbers3 = { 3, 4, 5, 6, 7, 1, 2 };
        int[] numbers4 = { 4, 5, 6, 7, 1, 2, 3 };
        int[] numbers5 = { 5, 6, 7, 1, 2, 3, 4 };
        int[] numbers6 = { 6, 7, 1, 2, 3, 4, 5 };
        int[] numbers7 = { 7, 1, 2, 3, 4, 5, 6 };
        switch (startingDay) {
            case 1:
                return numbers1;
            case 2:
                return numbers2;
            case 3:
                return numbers3;
            case 4:
                return numbers4;
            case 5:
                return numbers5;
            case 6:
                return numbers6;
            case 7:
                return numbers7;
            default:
                throw new Error("Wrong day");
        }
    }

    private static void printMonthName(int monthId) {
        String[] monthNames = { "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь",
                "Октябрь", "Ноябрь", "Декабрь",

        };
        System.out.println(" ---- " + monthNames[monthId] + " ----");
    }

    private static void printDaysOfWeeks(int startingDay) {
        String[] dayNames = { "Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс" };

        for (int i : Main1.getDaysLoop(startingDay)) {
            System.out.print(dayNames[i - 1] + " ");
        }
        System.out.println();
    }

    public static void printCurrentYear(int startingDayOfWeek) {
        var cur = Calendar.getInstance();
        cur.set(Calendar.MONTH, 0);
        cur.set(Calendar.DATE, 1);
        cur.set(Calendar.HOUR, 0);
        cur.set(Calendar.MINUTE, 0);
        cur.set(Calendar.SECOND, 0);

        var currentYear = cur.get(Calendar.YEAR);

        while (cur.get(Calendar.YEAR) == currentYear) {
            var currentMonth = cur.get(Calendar.MONTH);

            Main1.printMonthName(currentMonth);
            Main1.printDaysOfWeeks(startingDayOfWeek);

            // Print spacers for previous days (if any)
            for (int i : Main1.getDaysLoop(startingDayOfWeek)) {
                if (i == cur.get(Calendar.DAY_OF_WEEK)) {
                    break;
                }
                System.out.print("   ");
            }

            while (cur.get(Calendar.MONTH) == currentMonth) {
                var dayOfWeek = cur.get(Calendar.DAY_OF_WEEK);
                var dayOfMonth = cur.get(Calendar.DAY_OF_MONTH);

                // Print newline before writing date
                // Skipping 1 day because we are already on new line
                if (((dayOfWeek - 1) % 7) + 1 == startingDayOfWeek && dayOfMonth != 1) {
                    System.out.println("");
                }

                System.out.format("%02d ", dayOfMonth);

                cur.add(Calendar.DATE, 1);
            }
            // Ending line with dates
            System.out.println("");

            // A separator
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int startingDayOfWeek = args.length > 0 ? Integer.parseInt(args[0]) : 1;

        Main1.printCurrentYear(startingDayOfWeek);
    }
}
