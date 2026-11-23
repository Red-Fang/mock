package fr.umfds.exo1;

import static java.lang.Thread.sleep;

public class UsedClass {
    public long treatment1() throws TreatmentException{
        long time=System.currentTimeMillis();
        if (time%10==0){
            throw new TreatmentException();
        }else{
            return time%1000;
        }
    }

    public boolean treatment2() {
        long time=System.currentTimeMillis();
        // very long treatment
        try {
            sleep(100000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (time%2==0){
            return true;
        }else{
            return false;
        }
    }
}
