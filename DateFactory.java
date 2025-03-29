package za.ac.cput.factory;

import za.ac.cput.domain.Date;
import za.ac.cput.factory.DateHelper;

public class DateFactory {
    public static Date createDate(int dateID, String day, String month, String year) {
        if (dateID <= 0)
            throw new IllegalArgumentException("Date ID must be a positive real ID");
        if (DateHelper.isNullOrEmpty(day))
            throw new IllegalArgumentException("Day field can't be empty");
        if (DateHelper.isNullOrEmpty(month))
            throw new IllegalArgumentException("Month field can't be empty");
        if (DateHelper.isNullOrEmpty(year))
            throw new IllegalArgumentException("Year field must be filled");

        return new Date.DateBuilder()
                .dateID(dateID)
                .day(day)
                .month(month)
                .year(year)
                .build();
    }

    public static Date createBasic() {
        return new Date.DateBuilder()
                .dateID(1)
                .day("15")
                .month("10")
                .year("2023")
                .build();
    }
}



