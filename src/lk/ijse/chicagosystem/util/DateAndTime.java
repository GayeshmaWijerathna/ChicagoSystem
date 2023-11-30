package lk.ijse.chicagosystem.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTime {

    //set date
    public static String dateNow() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }

    public static String timeNow() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
        return dateFormat.format(new Date());
    }
}
