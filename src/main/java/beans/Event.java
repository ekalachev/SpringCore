package beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {
    private final int id;
    private String msg;
    private final Date date;
    private final DateFormat df;

    public Event(Date date, DateFormat df) {
        this.id = Math.abs(new Random().nextInt());
        this.date = date;
        this.df = df;
    }

    public int getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public String toString() {
        return "[date: " + this.df.format(this.date)
                + ", id: " + this.id
                + ", msg: " + this.msg
                + "]";
    }
}
