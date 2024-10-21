package nmit05.nmit05e02.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class DateService {
    public long difference(LocalDate date1, LocalDate date2) throws Exception {
        if (date1.isBefore(date2)) {
            return ChronoUnit.DAYS.between(date1, date2);
        } else {
            System.out.println(2);
            throw new Exception("Date 1 is after than Date 2");
        }
    }

    public ArrayList<Integer> leapYears(LocalDate date1, LocalDate date2) throws Exception {
        if (date1.isBefore(date2)) {
            ArrayList<Integer> leapYearsList = new ArrayList<>();
            for (int i = date1.getYear(); i <= date2.getYear(); i += 1) {
                if (isLeap(i)) {
                    leapYearsList.add(i);
                }
            }
            return leapYearsList;
        } else {
            throw new Exception("Date 1 is after than Date 2");
        }

    }

    public int january(LocalDate date1, LocalDate date2) throws Exception {
        if (date1.isBefore(date2)) {
            int count = 0;
            for (int i = date1.getYear(); i < date2.getYear(); i++) {
                if (LocalDate.of(i, 1, 1).getDayOfWeek() == DayOfWeek.SUNDAY) {
                    count++;
                }
            }
            return count;
        } else {
            throw new Exception("Date 1 is after than Date 2");
        }
    }

    protected static boolean isLeap(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    }
}
