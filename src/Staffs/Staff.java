package Staffs;

import Observers.RequestObservable;

import javax.swing.*;
import java.util.Stack;

/**
 * Created by JerryLau on 12/4/2016.
 */
public abstract class Staff {
    protected Stack<RequestObservable> unreadRequest;
    protected String name;
    public Staff() {
        this(null);
    }
    public Staff(String name) {
        this.name = name;
        unreadRequest = new Stack<RequestObservable>();
    }
    public String toString() {
        return this.name;
    }
    protected abstract void Accept(RequestObservable r);
    protected void Decline(RequestObservable r) {
        r.setStatus(RequestObservable.StatusList.Declined);
    }
    public void ProcessRequest() {
        while (!unreadRequest.isEmpty()) {
            RequestObservable r = unreadRequest.pop();

            if (r.getName().equals(this.name)) {
                String status = null;
                switch (r.getStatus()) {
                    case Endorsed:
                        status = "Endorsed";
                        break;
                    case Declined:
                        status = "Declined";
                        break;
                    case Unread:
                        status = "Unread";
                        break;
                }
                JOptionPane.showMessageDialog(null, "Your leaving " + r.getInfo() + " has been " + status);
                return;
            }
            int choice = JOptionPane.showOptionDialog(null, r.getInfo(), "Leaving Application", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (choice == JOptionPane.YES_OPTION)
                Accept(r);
            else
                Decline(r);
        }
    }
    public abstract void Approver(RequestObservable r);
}
