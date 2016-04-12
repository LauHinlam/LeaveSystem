package Staffs;

import Observers.RequestObservable;
import Observers.SenderObserver;
import Observers.RequestObserver;


import Tools.Date;
import Tools.Request;

/**
 * Created by JerryLau on 12/4/2016.
 */
public class Employee extends Staff {
    protected Staff supervisor;

    public Employee(String name) {
        this(name, null);
    }

    public Employee(String name, Staff supervisor) {
        this.name = name;
        this.supervisor = supervisor;
    }

    public void setSupervisor(Staff s) {
        this.supervisor = s;
    }

    protected void Accept(RequestObservable r) {
        RequestObserver status = new RequestObserver(r);
        RequestObservable ro = new RequestObservable(r.getRequest());
        ro.addObserver(status);
        this.supervisor.Approver(ro);
    }

    public void Approver(RequestObservable r) {
        this.unreadRequest.push(r);
    }

    public void RequestALeave(Date leaveStart, Date leaveEnd) {
        Request r = new Request(this.name, leaveStart, leaveEnd);
        RequestObservable req = new RequestObservable(r);
        SenderObserver obs = new SenderObserver(this);
        req.addObserver(obs);
        supervisor.Approver(req);
    }
}
