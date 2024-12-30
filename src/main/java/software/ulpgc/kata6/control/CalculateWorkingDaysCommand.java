package software.ulpgc.kata6.control;

import software.ulpgc.kata6.model.Calendar;

import java.time.LocalDate;

public class CalculateWorkingDaysCommand implements Command {
    private final Input input;
    private final Output output;
    private final Calendar calendar;

    public CalculateWorkingDaysCommand(Input input, Output output, Calendar calendar) {
        this.input = input;
        this.output = output;
        this.calendar = calendar;
    }

    @Override
    public void execute() {
        int daysWorked = 0;
        for(LocalDate localDate : calendar.from(input.startDate())){
            if(localDate.isAfter(input.endDate())){
                break;
            }
            daysWorked++;
        }
        output.days(daysWorked);
    }

    public interface Input{
        LocalDate startDate();
        LocalDate endDate();
    }

    public interface Output{
        void days(int days);
    }
}
