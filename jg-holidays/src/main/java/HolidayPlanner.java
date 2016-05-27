import java.util.Collections;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HolidayPlanner {

    private static final String LHR = "LHR";
    private static final String PFO = "PFO";

    private final FlightSupplier flightSupplier;
    private final VillaSupplier villaSupplier;

    public List<String> getHolidays(Integer week, Integer year) {
        if (flightSupplier.check(week, year, LHR, PFO)) {
            return villaSupplier.check(week, year);
        }
        return Collections.emptyList();
    }

}
