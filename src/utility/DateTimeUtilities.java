package utility;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Random;


/**
 *
 * @author Mitch
 */
public class DateTimeUtilities {

    /**
     * This method takes a dateTime and a pattern and converts the dateTime into the designated pattern. 
     * 
     * @param dateTime
     * @param pattern
     * @return dateTimeString
     */
    public final String formatLocalDateTimeToFormattedString(LocalDateTime dateTime, String pattern) {
        String dateTimeString = "";

        dateTimeString = dateTime.format(DateTimeFormatter.ofPattern(pattern));
        return dateTimeString;
    }

    public final LocalDate parseFormattedStringToLocalDateTime(String dateTimeString){
    
        String str = dateTimeString;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate dateTime = LocalDate.parse(str, formatter);
        return dateTime;
    }
        
    /**
     * Convert a formatted string to a LocalDateTime object
     *
     * @param dateTimeString
     * @return
     */
    public final LocalDateTime parseStringToLocalDateTime(String dateTimeString) {

        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString);
        return dateTime;
    }

    /**
     * Get the difference in some time unit between two dates, times or both
     *
     * @param firstDateTimeString
     * @param secondDateTimeString
     * @param dateType
     * @return
     */
    public final double getDifferenceDateTime(String firstDateTimeString, String secondDateTimeString, String dateType) {
        double difference = 0;

        LocalDateTime firstDateTime = parseStringToLocalDateTime(firstDateTimeString);
        LocalDateTime secondDateTime = parseStringToLocalDateTime(secondDateTimeString);

        difference = firstDateTime.until(secondDateTime, ChronoUnit.valueOf(dateType));
        return difference;
    }

    /**
     * @param firstDate
     * @param secondDate
     * @param pick
     * @return
     */
    public final String getPeriodBetweenDateParts(LocalDate firstDate, LocalDate secondDate, String pick) {

        LocalDate d1 = firstDate;
        LocalDate d2 = secondDate;

        Period period = Period.between(d1, d2);

        String days = String.valueOf(period.getDays()) + " Days";
        String months = String.valueOf(period.getMonths()) + " Months";
        String years = String.valueOf(period.getYears()) + " Years";
        String all = days + " " + months + " " + years;

        String oper = pick;

        if ("days".equals(oper)) {
            return days;
        } else if ("months".equals(oper)) {
            return months;
        } else if ("years".equals(oper)) {
            return years;
        } else {
            return all;
        }
    }

//    public final LocalDateTime getRandomTime(LocalDateTime checkInTime, LocalDateTime checkOutTime) {
//        
////        Random rand = new Random(seed);
////        int random_integer = rand.nextInt(2400-1m) + lowerbound
//        
//        
////        long offset = Timestamp.valueOf("2012-01-01 00:00:00").getTime();
////        long end = Timestamp.valueOf("2013-01-01 00:00:00").getTime();
////        long diff = end - offset + 1;
////        Timestamp rand = new Timestamp(offset + (long) (Math.random() * diff));
//    }
}
