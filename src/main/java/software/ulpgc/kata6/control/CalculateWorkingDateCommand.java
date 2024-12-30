package software.ulpgc.kata6.control;

import software.ulpgc.kata6.model.Calendar;

import java.time.LocalDate;

public class CalculateWorkingDateCommand implements Command {
    private final Input input;
    private final Output output;
    private final Calendar calendar;

    public CalculateWorkingDateCommand(Input input, Output output, Calendar calendar) {
        this.input = input;
        this.output = output;
        this.calendar = calendar;
    }

    @Override
    public void execute() {
        int days = input.workDays();
        for(LocalDate date : calendar.from(input.startDate())){
            days--;
            if(days <= 0){
                output.end(date);
                break;
            }
        }
    }

    public interface Input{
        LocalDate startDate();
        int workDays();
    }

    public interface Output{
        void end(LocalDate date);
    }
}
