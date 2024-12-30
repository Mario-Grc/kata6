package software.ulpgc.kata6.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;

import static java.time.DayOfWeek.*;

public class Calendar {
    private static Set<DayOfWeek> workingDays = Set.of(
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
    );

    public Iterable<LocalDate> from(LocalDate date) {
        return () -> iteratorFrom(date);
    }

    private Iterator<LocalDate> iteratorFrom(LocalDate date) {
        return new Iterator<LocalDate>() {
            private LocalDate current = date.minusDays(1);

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public LocalDate next() {
                while(true){
                    current = current.plusDays(1);
                    if(isWorkingDate(current)) return current;
                }
            }
        };
    }

    private boolean isWorkingDate(LocalDate date) {
        return workingDays.contains(date.getDayOfWeek());
    }
}