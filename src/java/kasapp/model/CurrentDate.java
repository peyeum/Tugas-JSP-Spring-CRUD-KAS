// Package
package kasapp.model;

// Dependency
import java.time.DayOfWeek;
import java.time.LocalDate;

public class CurrentDate {

    public static LocalDate today = LocalDate.now();

    public static String getMonth() {
        int month = today.getMonthValue();
        String monthStr = null;

        switch (month) {
            case 1:
                monthStr = "January";
                break;
            case 2:
                monthStr = "Februari";
                break;
            case 3:
                monthStr = "Maret";
                break;
            case 4:
                monthStr = "April";
                break;
            case 5:
                monthStr = "Mei";
                break;
            case 6:
                monthStr = "Juni";
                break;
            case 7:
                monthStr = "Juli";
                break;
            case 8:
                monthStr = "Agustus";
                break;
            case 9:
                monthStr = "September";
                break;
            case 10:
                monthStr = "Oktober";
                break;
            case 11:
                monthStr = "November";
                break;
            case 12:
                monthStr = "Desember";
                break;
        }
        return monthStr;
    }

    public static String getDay() {
        DayOfWeek day = today.getDayOfWeek();
        String dayStr = null;
        switch (day.toString()) {
            case "MONDAY":
                dayStr = "Senin";
                break;
            case "TUESDAY":
                dayStr = "Selasa";
                break;
            case "WEDNESDAY":
                dayStr = "Rabu";
                break;
            case "THURSDAY":
                dayStr = "Kamis";
                break;
            case "FRIDAY":
                dayStr = "Jum'at";
                break;
            case "SATURDAY":
                dayStr = "Sabtu";
                break;
            case "SUNDAY":
                dayStr = "Minggu";
                break;

        }
        return dayStr;
    }

    public static String getTanggal() {
        return getDay() + ", " + today.getDayOfMonth() + " " + getMonth() + " " + today.getYear();
    }

    public static String getDate() {
        return today.toString();
    }
}
