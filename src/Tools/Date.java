package Tools;

import javax.swing.*;

/**
 * Created by JerryLau on 12/4/2016.
 */
public class Date {
    private int year;
    private int month;
    private int day;
    public Date(int year, int month, int day) {
        this.year  = year;
        this.month = month;
        this.day   = day;
    }
    public static Date DateInput(String msg) {
        String[] rawDate = JOptionPane.showInputDialog(msg).split("/");
        int year  = Integer.parseInt(rawDate[2]);
        int month = Integer.parseInt(rawDate[1]);
        int day   = Integer.parseInt(rawDate[0]);
        return new Date(year, month, day);
    }
    public String FormatedOutput() {
        return String.format("%02d-%02d-%4d", this.day, this.month, this.year);
    }
}
