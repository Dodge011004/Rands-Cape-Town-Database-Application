package za.ac.cput.factory;

import za.ac.cput.domain.Date;

public class RunDate {
    public static void main(String[] args) {
        Date eventDate = new Date.DateBuilder()
                .dateID(5).day("1").month("October").year("2004")
                .build();

        System.out.println(eventDate.toString());
    }
}