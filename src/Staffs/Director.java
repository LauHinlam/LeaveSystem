package Staffs;

import Observers.RequestObservable;

/**
 * Created by JerryLau on 12/4/2016.
 */
public class Director extends Staff {

        private static Director drt = null;

        private Director() {
            super("Director");
        }

        public static Director getInstance() {
            if (drt == null) {
                drt = new Director();
            }
            return drt;
        }

        protected void Accept(RequestObservable r) {
            r.setStatus(RequestObservable.StatusList.Endorsed);
        }

        public void Approver(RequestObservable r) {
            this.unreadRequest.push(r);
        }

}
