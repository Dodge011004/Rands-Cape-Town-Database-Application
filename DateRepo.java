package za.ac.cput.repository;

import za.ac.cput.domain.Date;
import java.util.ArrayList;
import java.util.List;

//reused but modified
public class DateRepo implements iDateRepo {
    private final List<Date> dateRepList;
    private static final DateRepo repo = new DateRepo();

    private DateRepo(){
        this.dateRepList = new ArrayList<>();
    }

    public static DateRepo getRepo() {

        return repo;}

    @Override
    public Date create(Date date) {
        this.dateRepList.add(date);

        return date;
    }

    @Override
    public Date read(int dateId) {
        for (Date date : dateRepList) {
            if (date.getDateID() == dateId) {

                return date;
            }
        }

        return null;
    }

    @Override
    public Date update(Date date) {
        Date unchanged = read(date.getDateID());
        if (unchanged != null) {
            this.dateRepList.remove(unchanged);
            this.dateRepList.add(date);

            return date;
        }

        return null;
    }

    @Override
    public boolean delete(int dateId) {

        Date date = read(dateId);

        if (date != null) {
            this.dateRepList.remove(date);

            return true;
        }

        return false;
    }

    @Override
    public List<Date> getAll() {

        return new ArrayList<>(this.dateRepList);}
}