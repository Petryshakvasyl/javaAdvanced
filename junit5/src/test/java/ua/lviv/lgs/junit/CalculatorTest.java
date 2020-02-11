package ua.lviv.lgs.junit;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("DEBUG: before all");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("DEBUG: after all");
    }

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println(" DEBUG: before each");
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        System.out.println(" DEBUG: after each");
    }

    @Test
    public void addTest() {
        int expected = 15;
        int actual = calculator.add(9, 6);
        assertEquals(expected, actual);
    }

    @Test
    public void substractTest() {
        int expected = 6;
        int actual = calculator.substract(10, 4);
        assertEquals(expected, actual);
    }

    @Test
    public void substractTestWhenIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> calculator.substract(10, 14));
    }

    @Test
    public void multiply() {
        int expected = 36;
        int actual = calculator.multiply(6, 6);
        assertEquals(expected, actual);
    }

    @Test
    public void devide() {
        int expected = 6;
        int actual = calculator.devide(48, 8);
        assertEquals(expected, actual);
    }

    @Test
    public void devideByZeroThrowsIllegalException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.devide(10, 0));
    }

    @Test
    public void asserttNotNullTest() {
        String s = "Some value";
        assertNotNull(s);
    }

    @Test
    public void assertNullTest() {
        String s = null;
        assertNull(s);
    }

    @Test
    public void assertSameTest() {
        String s = "A";
        String s1 = "A";
        assertSame(s, s1);
    }

    @Test
    @Disabled("Waiting for implements tsk #1245")
    public void assertNotSameTest() {
        String s = "A";
        String s1 = new String("A");
        assertNotSame(s, s1);
    }

    @ParameterizedTest
    @CsvSource({
            "10, 25",
            "10, 26",
            "7, 66",
            "10, 86",
    })
    @DisplayName("Test few cases for adding...")
    public void addFiewTestCalses(int a, int b){
        assertThrows(IllegalArgumentException.class, () -> calculator.substract(a, b));
    }


    @ParameterizedTest
    @EnumSource(Seasons.class)
    public void seasonsTest(Seasons season){
        System.out.println(season);
    }

    enum Seasons{
        SPRING, SUMMER, FALL, WINTER
    }


    @ParameterizedTest
    @ValueSource(ints = { 1,3,5,8})
    public void seasonsTest(int val){
        System.out.println(val);
    }

}