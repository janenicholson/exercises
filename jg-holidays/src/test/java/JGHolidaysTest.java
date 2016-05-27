import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import lombok.RequiredArgsConstructor;

public class JGHolidaysTest {

    private final Integer WEEK = 26;
    private final Integer YEAR = 2011;
    private final String HOLIDAY1 = "Villa1ForWeek26";
    private final String HOLIDAY2 = "Villa2ForWeek26";
    private FlightSupplier flightSupplier;
    private VillaSupplier villaSupplier;

    @Test
    public void provides_list_of_villas_when_villas_and_flights_are_available() {
        stubSuppliers(true, Arrays.asList(HOLIDAY1, HOLIDAY2));
        assertThat(new HolidayPlanner(flightSupplier, villaSupplier).getHolidays(WEEK, YEAR), hasItems(HOLIDAY1, HOLIDAY2));
    }

    @Test
    public void provides_empty_list_when_there_are_flights_but_no_villas() {
        stubSuppliers(true, Collections.emptyList());
        assertTrue(new HolidayPlanner(flightSupplier, villaSupplier).getHolidays(WEEK, YEAR).isEmpty());
    }

    @Test
    public void provides_empty_list_when_there_are_villas_but_no_flights() {
        stubSuppliers(false, Arrays.asList(HOLIDAY1, HOLIDAY2));
        assertTrue(new HolidayPlanner(flightSupplier, villaSupplier).getHolidays(WEEK, YEAR).isEmpty());
    }

    @RequiredArgsConstructor
    public class StubFlightSupplier implements FlightSupplier {
        private final boolean available;
        @Override
        public boolean check(Integer week, Integer year, String originAirport, String destinationAirport) {
            return available;
        }
    }

    @RequiredArgsConstructor
    public class StubVillaSupplier implements VillaSupplier {
        private final List<String> available;
        @Override
        public List<String> check(Integer week, Integer year) {
            return available;
        }
    }

    private void stubSuppliers(boolean flightsAvailable, List<String> villasAvailable) {
        flightSupplier = new StubFlightSupplier(flightsAvailable);
        villaSupplier = new StubVillaSupplier(villasAvailable);
    }

}
