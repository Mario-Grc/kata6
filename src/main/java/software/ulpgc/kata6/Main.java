package software.ulpgc.kata6;

import software.ulpgc.kata6.adapters.CalcualteWorkingDateAdapter;
import software.ulpgc.kata6.adapters.CalculateWorkingDaysAdapter;
import software.ulpgc.kata6.control.CalculateWorkingDateCommand;
import software.ulpgc.kata6.control.CalculateWorkingDaysCommand;
import software.ulpgc.kata6.control.Command;
import software.ulpgc.kata6.model.Calendar;
import spark.Request;
import spark.Response;

public class Main {
    public static void main(String[] args) {
        new WebService(
                new CommandFactory()
                        .add("/working-days", ((request, response) -> createWorkingDaysCommand(request, response)))
                        .add("/working-date", ((request1, response1) -> createWorkingDateCommand(request1, response1)))
        ).init();
    }

    private static CalculateWorkingDateCommand createWorkingDateCommand(Request request1, Response response1) {
        return new CalculateWorkingDateCommand(
                CalcualteWorkingDateAdapter.adapt(request1),
                CalcualteWorkingDateAdapter.adapt(response1),
                new Calendar()
        );
    }

    private static CalculateWorkingDaysCommand createWorkingDaysCommand(Request request, Response response) {
        return new CalculateWorkingDaysCommand(
                CalculateWorkingDaysAdapter.adapt(request),
                CalculateWorkingDaysAdapter.adapt(response),
                new Calendar()
        );
    }
}
