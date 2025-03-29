package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.domain.Date;
import za.ac.cput.factory.DateFactory;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class DateFactoryTest {

    private Date testDate;

    @BeforeEach
    void setUp() {
        testDate = new Date.DateBuilder()
                .dateID(324)
                .day("1")
                .month("October")
                .year("2004")
                .build();
    }

    @Test
    @Order(1)
    public void testNotNull() {
        assertNotNull(testDate);
        System.out.println(testDate.toString());
    }

    @Test
    @Order(2)
    public void testDateValues() {
        assertEquals(324, testDate.getDateID());
        assertEquals("1", testDate.getDay());
        assertEquals("October", testDate.getMonth());
        assertEquals("2004", testDate.getYear());
        System.out.println(testDate.toString());
    }

    @Test
    @Order(3)
    public void testInvalidID() {
        assertThrows(IllegalArgumentException.class, () ->
                DateFactory.createDate(-6, "15", "October", "1738"));
    }

    @Test
    @Order(4)
    public void testEmptyDay() {
        assertThrows(IllegalArgumentException.class, () ->
                DateFactory.createDate(1, "", "August", "2019"));
    }

    @Test
    @Order(5)
    public void testCreateBasic() {
        Date basicDate = DateFactory.createBasic();
        assertNotNull(basicDate);
        assertEquals(1, basicDate.getDateID());
        assertEquals("15", basicDate.getDay());
        assertEquals("10", basicDate.getMonth());
        assertEquals("2023", basicDate.getYear());
    }
}