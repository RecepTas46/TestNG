package Gun04;

import org.testng.annotations.*;

public class _01_Intro {
    /*
              @BeforeSuite
                @BeforeTest
                  @BeforeGroups
                     @BeforeClass
                        @BeforeMethod
                            @Test
                            @Test
                        @AfterMethod
                     @AfterClass
                  @AfterGroups
                @AfterTest
              @AfterSuite
        */
    @BeforeSuite
    void bSuite() {
        System.out.println("Before Suite");
    }

    @BeforeTest
    void bTest() {
        System.out.println("Before Test");
    }

    @BeforeGroups
    void bGroups() {
        System.out.println("Before Groups");
    }

    @BeforeClass
    void bClas() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    void bMethod() {
        System.out.println("Before Method");
    }

    @Test
    void testIntro_1() {
        System.out.println("Test intro 1");
    }

    @Test
    void testIntro_2() {
        System.out.println("Test intro 2");
    }

    @AfterSuite
    void aSuite() {
        System.out.println("After Suite");
    }

    @AfterTest
    void aTest() {
        System.out.println("After Test");
    }

    @AfterGroups
    void aGroups() {
        System.out.println("After Groups");
    }

    @AfterClass
    void aClas() {
        System.out.println("After Class");
    }

    @AfterMethod
    void aMethod() {
        System.out.println("After Method");
    }


}

