package tests;

import org.junit.jupiter.api.*;

public class jUnitExample {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Here is before()");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Here is beforeEach()");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Here is after()");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Here is afterEach()");
    }

    @Test
    void firstTest() {
        System.out.println("Here is firstTest()");
    }

    @Test
    void secondTest() {
        System.out.println("Here is secondTest()");
    }
}
