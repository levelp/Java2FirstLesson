import org.junit.*;

import static util.Calc.fact;

public class HWTest extends Assert {
    @BeforeClass
    public static void classSetUp() {
        System.out.println("Перед всеми тестами в данном классе");
    }

    @BeforeClass
    public static void classSetUp2() {
        System.out.println("Перед всеми тестами в данном классе 2");
    }

    @AfterClass
    public static void classTearDown() {
        System.out.println("После всех тестов в классе");
    }

    @Test
    public void testHelloWorld() throws Exception {
        HW.main();
        //HW.main("1", "2");
    }

    @Test
    public void testStringPerformance() throws Exception {
        String s = "";
        for (int i = 0; i < 10000; i++) {
            s += i;
        }
    }

    @Test
    public void testStringBuilderPerformance() throws Exception {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            s.append(i);
        }
    }

    @Test
    public void testDemoSimpleAsserts() {
        assertEquals("Сложение целых чисел", 4, 2 + 2);
        assertEquals("Сложение чисел типа double",
                3.3, 1.2 + 2.1, 0.0000001);

        Object obj = null;
        assertNull(obj);
        obj = new Object();
        assertNotNull(obj);

        boolean b1 = (4 > 3);
        assertTrue(b1);
        assertFalse(5 < 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException() throws Exception {
        throw new IllegalArgumentException("");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Перед каждым тестом");
    }

    @After
    public void tearDown() {
        System.out.println("После каждого теста");
    }

    @Test
    public void testFactorial() throws Exception {
        assertEquals(1, fact(1));
        assertEquals(1 * 2, fact(2));
        assertEquals(1 * 2 * 3, fact(3));
        assertEquals(1 * 2 * 3 * 4, fact(4));
        assertEquals(1, fact(0));
    }
}
