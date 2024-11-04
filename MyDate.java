
public class MyDate {
    public static void main(String[] args) {
        MyDate d1 = new MyDate(2012, 2, 28);
        System.out.println(d1);
        System.out.println(d1.nextDay());
        System.out.println(d1.nextDay());
        System.out.println(d1.nextMonth());
        System.out.println(d1.nextYear());
        MyDate d2 = new MyDate(2012, 1, 2);
        System.out.println(d2);
        System.out.println(d2.previousDay());
        System.out.println(d2.previousDay());
        System.out.println(d2.previousMonth());
        System.out.println(d2.previousYear());
    }


    int year, month, day;

    public static final String[] MONTHS = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    public static final String[] DAYS = {
            "Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"
    };

    public static final int[] DAYS_IN_MONTHS = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public MyDate(int year, int month, int day) {
        setDate(year, month, day);
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean isValidDate(int year, int month, int day) {
        if (year < 1 || year > 9999) return false;
        if (month < 1 || month > 12) return false;

        int dayMax = DAYS_IN_MONTHS[month - 1];
        if (month == 2 && isLeapYear(year)) {
            dayMax = 29;
        }

        return day >= 1 && day <= dayMax;
    }

    public static int getDayOfWeek(int year, int month, int day) {
        int[] t = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        if (month < 3) year -= 1;
        return (year + year/4 - year/100 + year/400 + t[month-1] + day) % 7;
    }

    public void setDate(int year, int month, int day) {
        if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException("Invalid!");
        }
            this.year = year;
            this.month = month;
            this.day = day;
    }


    public void setYear(int year) {
        if (year < 1 || year > 9999) {
            throw new IllegalArgumentException("Invalid year!");
        }
        this.year = year;
        }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month!");
                     }
        this.month = month;
    }

    public void setDay(int day) {
        if (day < 1 || day > DAYS_IN_MONTHS[month - 1] ||
                (month == 2 && day == 29 && !isLeapYear(year))) {
            throw new IllegalArgumentException("Invalid day!");
        }
        this.day = day;
    }

    public int getYear() { return year; }
    public int getMonth() { return month; }
    public int getDay() { return day; }

    public String toString() {
        int dayOfWeek = getDayOfWeek(year, month, day);
        return DAYS[dayOfWeek] + " " + day + " " + MONTHS[month - 1] + " " + year;
    }

    public MyDate nextDay() {
        if (isValidDate(year, month, day + 1)) {
            day++;
        } else if (isValidDate(year, month + 1, 1)) {
            day = 1;
            month++;
        } else {
            day = 1;
            month = 1;
            year++; }
        return this;
    }

    public MyDate nextMonth() {
        if (month == 12) {
            month = 1;
            year++;
        } else {
            month++;
        }

        int dayMax = DAYS_IN_MONTHS[month - 1];
        if (month == 2 && isLeapYear(year)) {
            dayMax = 29;
        }
        if (day > dayMax) {
            day = dayMax;
        }
        return this;
    }

    public MyDate nextYear() {
        if (year == 9999) {
            throw new IllegalStateException("Invalid!");
        }
        year++;
        if (month == 2 && day == 29 && !isLeapYear(year)) {
            day = 28;
        }
        return this;
    }

    public MyDate previousDay() {
        if (isValidDate(year, month, day - 1)) {
            day--;
        } else if (isValidDate(year, month - 1, 1)) {
            month--;
            day = DAYS_IN_MONTHS[month - 1];
            if (month == 2 && isLeapYear(year)) {
                day = 29;
            }
        } else {
            month = 12;
            day = 31;
            year--;
        }
        return this;
    }

    public MyDate previousMonth() {
        if (month == 1) {
            month = 12;
            year--;
        } else {
            month--;
        }

        int dayMax = DAYS_IN_MONTHS[month - 1];
        if (month == 2 && isLeapYear(year)) {
            dayMax = 29;
        }
        if (day > dayMax) {
            day = dayMax;
        }
        return this;
    }

    public MyDate previousYear() {
        if (year == 1) {
            throw new IllegalStateException("Invalid!");
        }
        year--;
        if (month == 2 && day == 29 && !isLeapYear(year)) {
            day = 28;
        }
        return this;
    }
}
