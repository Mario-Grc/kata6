package software.ulpgc.kata6.adapters;

import software.ulpgc.kata6.control.CalculateWorkingDaysCommand;
import spark.Request;
import spark.Response;

import java.time.LocalDate;

public class CalculateWorkingDaysAdapter {
    public static CalculateWorkingDaysCommand.Input adapt(Request request) {
        return new CalculateWorkingDaysCommand.Input() {
            @Override
            public LocalDate startDate() {
                return LocalDate.parse(request.queryParams("startDate"));
            }

            @Override
            public LocalDate endDate() {
                return LocalDate.parse(request.queryParams("endDate"));
            }
        };
    }

    public static CalculateWorkingDaysCommand.Output adapt(Response response) {
        return new CalculateWorkingDaysCommand.Output() {
            @Override
            public void days(int days) {
                response.body(String.valueOf(days));
            }
        };
    }
}
