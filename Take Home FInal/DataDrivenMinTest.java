import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* 
 * Fullname: John Stephen Gutam
 * GNumber: G01413212
 */

@RunWith(Parameterized.class)
public class DataDrivenMinTest {

    @Parameterized.Parameter(0)
    public List<? extends Comparable<?>> list;

    @Parameterized.Parameter(1)
    public Comparable<?> expected;

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList("apple", "banana", "cherry"), "apple"},
                {Arrays.asList(5, 2, 8, 1), 1},
                {Arrays.asList(3.14, 1.618, 2.718), 1.618},
                {Arrays.asList(), null} // Testing empty list
        });
    }

    @Test
    public void testMin() {
        Comparable<?> result = Min.min(list);
        Assert.assertEquals(expected, result);
    }
}
