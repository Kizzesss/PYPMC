import java.util.Calendar;

public enum Dias {

    LUN(Calendar.MONDAY, "Lunes"), MAR(Calendar.TUESDAY, "Martes"), MIE(Calendar.WEDNESDAY, "Miercoles"), 
    JUE(Calendar.THURSDAY, "Jueves"), VIE(Calendar.FRIDAY, "Viernes");

    private int numeroDia;
    private String nombreDia;

    private Dias(int numeroDia, String nombreDia) {
        this.numeroDia = numeroDia;
        this.nombreDia = nombreDia;
    }

    public int getNumeroDia() {
        return numeroDia;
    }

    public void setNumeroDia(int numeroDia) {
        this.numeroDia = numeroDia;
    }

    public String getNombreDia() {
        return nombreDia;
    }

    public void setNombreDia(String nombreDia) {
        this.nombreDia = nombreDia;
    }

}