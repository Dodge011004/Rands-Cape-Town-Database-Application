package za.ac.cput.repository;

import za.ac.cput.domain.Date;
import java.util.List;

public interface iDateRepo {
    Date create(Date date);
    Date read(int dateId);
    Date update(Date date);
    boolean delete(int dateId);
    List<Date> getAll();
}