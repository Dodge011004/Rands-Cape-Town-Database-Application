package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Date;
import za.ac.cput.factory.DateFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DateRepositoryTest {
    private static final iDateRepo repository = DateRepo.getRepo();
    private static Date date = DateFactory.createDate(1, "4", "July", "2000");
    private static Date testDate = new Date.DateBuilder()
            .dateID(324)
            .day("1")
            .month("October")
            .year("2004")
            .build();

    @Test
    @Order(1)
    public void create() {
        Date created = repository.create(date);
        assertEquals(date.getDateID(), created.getDateID());

        System.out.println("Created: " + created);
    }

    @Test
    @Order(2)
    public void read() {
        repository.create(date);

        Date read = repository.read(date.getDateID());

        assertNotNull(read);
        assertEquals(date.getDateID(), read.getDateID());

        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    public void update() {
        repository.create(date);

        Date updated = new Date.DateBuilder()
                .dateID(date.getDateID())
                .day("20")  //target
                .month(date.getMonth())
                .year(date.getYear())
                .build();

        Date result = repository.update(updated);

        assertNotNull(result);
        assertEquals("20", result.getDay());

        System.out.println("Updated: " + updated);
    }

    @Test
    @Order(4)
    public void delete() {
        // First create the date
        repository.create(date);

        boolean success = repository.delete(date.getDateID());

        assertTrue(success);

        System.out.println("Deleted: " + success);
    }

    @Test
    @Order(5)
    public void getAll() {
        // Clear data
        clearRepository();

        repository.delete(date.getDateID());
        repository.delete(testDate.getDateID());

        // test
        Date dateF = DateFactory.createDate(1, "1", "December", "2015");
        Date dateY = DateFactory.createDate(2, "9", "October", "2004");

        // add 2 repo
        repository.create(dateF);
        repository.create(dateY);

        // Get
        List<Date> allDates = repository.getAll();

        // Verify
        assertFalse(allDates.isEmpty(), "Repository must not be empty");
        assertEquals(2, allDates.size(), "Only 2 dates must be contained inside the repo");
        assertTrue(allDates.contains(dateF), "Should contain date F");
        assertTrue(allDates.contains(dateY), "Should contain date Y");

        System.out.println("All Dates: " + allDates);
    }

    @Test
    @Order(6)
    public void testTestDate() {
        assertNotNull(testDate);
        assertEquals(324, testDate.getDateID());
        System.out.println("Test Date: " + testDate);
    }


    private void clearRepository() {
        List<Date> allDates = repository.getAll();
        for (Date d : allDates) {
            repository.delete(d.getDateID());
        }
    }//old code
}