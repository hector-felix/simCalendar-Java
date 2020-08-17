/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem1;

/**
 *
 * @author mac
 */
import java.util.Scanner;

public class calendar { //USE 2D Arraylist or 2Day array to align days

// computing weekday as per algorithm on wiki
    private static int day(int month, int day, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y / 4 - y / 100 + y / 400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31 * m) / 12) % 7;
        return d;
    }

// Leap year check
    private static boolean isLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0)) {
            return true;
        }
        if (year % 400 == 0) {
            return true;
        }
        return false;
    }

// array for month names
    private final static String[] MONTHS
            = {
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
            };

// array for number of days in a month indexed 0 -> Jan
    private static int[] MONTH_DAYS = {
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    private static final String[] daysOfWeek = {
        "Sun",
        "Mon",
        "TUE",
        "Wed",
        "Thurs",
        "Fri",
        "Sat"
    };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year to print its calendar: ");
        int year = Integer.parseInt(sc.nextLine());
        sc.close();

        if (isLeapYear(year)) {
            MONTH_DAYS[1] = 29;
        }

        int startDayOfMonth = day(1, 1, year);
        int spaces = startDayOfMonth;

        for (int month = 0; month < MONTHS.length; month++) {
// print calendar header
// Display the month and year
            System.out.println(" " + MONTHS[month] + " " + year);

// Display the weekday
            System.out.println(" Sun  Mon  Tue  Wed  Thu  Fri  Sat");

// print the calendar
            for (int i = 0; i < spaces; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= MONTH_DAYS[month]; i++) {
                System.out.printf(" %3d ", i);
                if (((i + spaces) % 7 == 0) || (i == MONTH_DAYS[month])) {
                    System.out.println();
                }
            }
// spaces required
            spaces = (MONTH_DAYS[month] + spaces) % 7;
            System.out.println();
        }
    }
}
