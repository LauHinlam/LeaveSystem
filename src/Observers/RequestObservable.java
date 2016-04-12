package Observers;

import java.util.Observable;
import Tools.Request;

/**
 * Created by JerryLau on 12/4/2016.
 */
public class RequestObservable  extends Observable {
    public enum StatusList {
        Endorsed, Declined, Unread
    };

    private Request r;
    StatusList status = StatusList.Unread;

    public RequestObservable(Request r) {
        super();
        this.r = r;
    }

    public StatusList getStatus() {
        return this.status;
    }

    public String getInfo() {
        return r.PrintRequest();
    }

    public String getName() {
        return this.r.getStaffName();
    }

    public Request getRequest() {
        return r;
    }

    public void setStatus(StatusList s) {
        this.status = s;
        setChanged();
        notifyObservers();
    }
}
