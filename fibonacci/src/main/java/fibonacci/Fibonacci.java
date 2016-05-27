package fibonacci;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibonacci {

    public int nth(int i) {
        if (i < 2)
            return i;
        return nth(i-1) + nth(i-2);
    }

    public Integer[] getSequence(int i) {
        if (i < 8 || i > 50)
            throw new RuntimeException("No!");
        return Stream.iterate(0, (x)->x+1)
                .limit(i)
                .map((x)->nth(x))
                .collect(Collectors.toList())
                .toArray(new Integer[]{});
    }

}
