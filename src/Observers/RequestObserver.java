package Observers;

import java.util.Observable;
import java.util.Observer;

public class RequestObserver implements Observer {
	RequestObservable toBeNotified = null;
	public RequestObserver(RequestObservable ro) {
		super();
		this.toBeNotified = ro;
	}
	public void update(Observable o, Object obj) {
		RequestObservable ro = (RequestObservable) o;
		toBeNotified.setStatus(ro.getStatus());
	}
}