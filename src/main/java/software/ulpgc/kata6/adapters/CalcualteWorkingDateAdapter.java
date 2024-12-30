package software.ulpgc.kata6.adapters;

import software.ulpgc.kata6.control.CalculateWorkingDateCommand;
import spark.Request;
import spark.Response;

import java.time.LocalDate;

public class CalcualteWorkingDateAdapter {
    public static CalculateWorkingDateCommand.Input adapt(Request request){
        return new CalculateWorkingDateCommand.Input() {
            @Override
            public LocalDate startDate() {
                return LocalDate.parse(request.queryParams("startDate"));
            }

            @Override
            public int workDays() {
                return Integer.parseInt(request.queryParams("workDays"));
            }
        };
    }

    public static CalculateWorkingDateCommand.Output adapt(Response response){
        return new CalculateWorkingDateCommand.Output() {
            @Override
            public void end(LocalDate date) {
                response.body(date.toString());
            }
        };
    }
}
