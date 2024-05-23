import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
 * Fullname: John Stephen Gutam
 * Gnumber: G01413212
 * */

public class BoundedQueueTest {

    private BoundedQueue queue;

    @Before
    public void setUp() {
        queue = new BoundedQueue(3);
    }

    @Test
    public void testEnQueue() {
        queue.enQueue("test");
        Assert.assertEquals("[test]", queue.toString());
    }

    @Test(expected = NullPointerException.class)
    public void testEnQueueNull() {
        queue.enQueue(null);
    }

    @Test(expected = IllegalStateException.class)
    public void testEnQueueFull() {
        queue.enQueue("test1");
        queue.enQueue("test2");
        queue.enQueue("test3");
        queue.enQueue("test4");
    }

    @Test
    public void testDeQueue() {
        queue.enQueue("test");
        Object result = queue.deQueue();
        Assert.assertEquals("test", result);
        Assert.assertTrue(queue.isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeQueueEmpty() {
        queue.deQueue();
    }

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(queue.isEmpty());
        queue.enQueue("test");
        Assert.assertFalse(queue.isEmpty());
    }

    @Test
    public void testIsFull() {
        Assert.assertFalse(queue.isFull());
        queue.enQueue("test1");
        queue.enQueue("test2");
        queue.enQueue("test3");
        Assert.assertTrue(queue.isFull());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("[]", queue.toString());
        queue.enQueue("test1");
        queue.enQueue("test2");
        queue.enQueue("test3");
        Assert.assertEquals("[test1, test2, test3]", queue.toString());
    }
}
