package za.ac.cput.domain;
/**
 Leslie 230453260 -entity: DATE
 */
import java.util.Objects;

public class Date {
    private final int dateID;
    private final String day;
    private final String month;
    private final String year;

    // constructor for builder use

    private Date(DateBuilder builder) {
        this.dateID = builder.dateID;
        this.day = builder.day;
        this.month = builder.month;
        this.year = builder.year;
    }

    // Get

    public int getDateID() { return dateID; }
    public String getDay() { return day; }
    public String getMonth() { return month; }
    public String getYear() { return year; }

    // Copy

    public Date copy() {
        return new DateBuilder()
                .dateID(this.dateID)
                .day(this.day)
                .month(this.month)
                .year(this.year)
                .build();
    }

    // equals+hashCode+toString

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return dateID == date.dateID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateID);
    }

    @Override
    public String toString() {
        return "Date{" +
                "dateID=" + dateID +
                ", day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    // Builder
    public static class DateBuilder {
        private int dateID;
        private String day;
        private String month;
        private String year;

        public DateBuilder dateID(int dateID) {
            this.dateID = dateID;
            return this;
        }

        public DateBuilder day(String day) {
            this.day = day;
            return this;
        }

        public DateBuilder month(String month) {
            this.month = month;
            return this;
        }

        public DateBuilder year(String year) {
            this.year = year;
            return this;
        }

        public Date build() {
            // Validating build
            if (dateID <= 0) {
                throw new IllegalArgumentException("Date ID must be a positive real ID");}

            if (day == null || day.isEmpty()) {
                throw new IllegalArgumentException("Day field can't be empty");}

            if (month == null || month.isEmpty()) {
                throw new IllegalArgumentException("Day field can't be empty");}

            if (year == null || year.isEmpty()) {
                throw new IllegalArgumentException("Day field can't be empty");}

            return new Date(this);
        }
    }
}