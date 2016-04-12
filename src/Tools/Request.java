package Tools;

/**
 * Created by JerryLau on 12/4/2016.
 */
public class Request {
    private Date leaveStart;
    private Date leaveEnd;
    public String staffName;

    public Request() {
        this(null, null, null);
    }

    public Request(String staffName, Date leaveStart, Date leaveEnd) {
        this.staffName = staffName;
        this.leaveStart = leaveStart;
        this.leaveEnd = leaveEnd;
    }

    public void setStartDate(Date d) {
        this.leaveStart = d;
    }

    public void setEndDate(Date d) {
        this.leaveEnd = d;
    }

    public void setStaffName(String n) {
        this.staffName = n;
    }

    public String getStaffName() {
        return this.staffName;
    }

    public String PrintRequest() {
        return new String(staffName + ": From " + leaveStart.FormatedOutput() + " to " + leaveEnd.FormatedOutput());
    }
}
