package fr.umfds.exo1;
public class ClassUnderTest {
    private UsedClass uc;

    public ClassUnderTest(UsedClass uc) {
        this.uc = uc;
    }



    public long m1(){
        long uct;
        try {
            uct=uc.treatment1();
        } catch (TreatmentException e) {
            return 0;
        }
        return uct+2;
    }

    public int m2(){
        boolean b=uc.treatment2();
        if (b){
            return 1;
        }else{
            return 0;
        }
    }

}
