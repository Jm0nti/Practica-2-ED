package Clases;

public class Fecha{
    private int dd;
    private int mm;
    private int aa;

    public Fecha(int dd, int mm, int aa) {
        this.dd = dd;
        this.mm = mm;
        this.aa = aa;
    }

    public int getDd() {
            return dd;
    }
    
    public int getMm() {
            return mm;
    }
    
    public int getAa() {
            return aa;
    }
    
    

    public void setDd(int dd) {
            this.dd = dd;
    }
    
    public void setMm(int mm) {
            this.mm = mm;
    }
    
    public void setAa(int aa) {
            this.aa = aa;
    }
}
