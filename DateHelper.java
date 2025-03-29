package za.ac.cput.factory;

public class DateHelper {

    // General validation
   // public static boolean isNullOrEmpty(String str) {
      //  return StringUtils.isEmpty(str); //this code no longer works after standardisation

    //method
        public static boolean isNullOrEmpty(String str) {
            return str == null || str.trim().isEmpty();
        }


    // Date validation (reused but modified significantly)
    public static String validateDay(String day) {
        if (isNullOrEmpty(day)) {
            throw new IllegalArgumentException("Day field can't be empty");}

        try {
            int dayVal = Integer.parseInt(day);
            if (dayVal < 1 || dayVal > 31) {
                throw new IllegalArgumentException("Day must be real and between 1 and 31");
             }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Day must be a valid day of month");
        }

        return day;
    }

    public static String validateMonth(String month) {
        if (isNullOrEmpty(month)) {
            throw new IllegalArgumentException("Month can't be left empty");
            }

        try {
            int monthVal = Integer.parseInt(month);
            if (monthVal < 1 || monthVal> 12) {
                throw new IllegalArgumentException("Month must be between 1 and 12");
            }
            } catch (NumberFormatException e){
            throw new IllegalArgumentException("Month must be a real number");
        }

        return month;
    }

    public static String validateYear(String year) {
        if (isNullOrEmpty(year)) {
            throw new IllegalArgumentException("Year field must contain a value");
        }

        try {
            int yearVal = Integer.parseInt(year);
            if (yearVal < 1900 || yearVal > 2100) {
                throw new IllegalArgumentException("Year must be between 1900 and 2100");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Year must be a valid number");
        }

        return year;
    }


}//End of Class Helper