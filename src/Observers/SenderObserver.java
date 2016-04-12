package Observers;

import java.util.Observable;
import java.util.Observer;
import Staffs.Employee;

/**
 * Created by JerryLau on 12/4/2016.
 */
public class SenderObserver implements Observer {
    Employee sender = null;
    public SenderObserver(Employee e) {
        super();
        this.sender = e;
    }
    public void update(Observable o, Object obj) {
        RequestObservable ro = (RequestObservable) o;
        sender.Approver(ro);
    }
}
