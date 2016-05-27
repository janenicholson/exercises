package fibonacci;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class FibonacciTest {

    @Test
    @Parameters({"0,0",
                 "1,1"})
    public void first_two_numbers_are_index(int index, int expectedResult) {
        assertThat(nthFibonacciNumber(index), is(equalTo(expectedResult)));
    }

    @Test
    @Parameters({"2,1",
                 "3,2",
                 "4,3",
                 "5,5"})
    public void numbers_are_sum_of_two_prior_numbers(int index, int expectedResult) {
        assertThat(nthFibonacciNumber(index), is(equalTo(expectedResult)));
    }

    @Test
    public void generate_sequence_of_eight_numbers() {
        assertArrayEquals(new Fibonacci().getSequence(8), new Integer[]{0,1,1,2,3,5,8,13});
    }

    @Test(expected=Exception.class)
    @Parameters({"7", "51"})
    public void not_extract_sequence_of_invalid_number_of_numbers(int numberOfNumbers) {
        new Fibonacci().getSequence(numberOfNumbers);
    }

    private int nthFibonacciNumber(int index) {
        return new Fibonacci().nth(index);
    }
}
