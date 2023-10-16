package Clases;

public class Direccion {
    private String calle;
    private String nomenclatura;
    private String barrio;
    private String ciudad;
    private String urbanizacion;
    private String noApartamento;


    public Direccion(String calle, String nomenclatura, String barrio, String ciudad, String urbanizacion,String noApartamento) {
        this.calle = calle;
        this.nomenclatura = nomenclatura;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.urbanizacion = urbanizacion;
        this.noApartamento = noApartamento;
    }

    public String getCalle() {
        return calle;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public String getBarrio() {
        return barrio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String toString() {
        return calle + " " + nomenclatura + " " + barrio + " " + ciudad + " " + urbanizacion + " " + noApartamento;
    }
     
    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getUrbanizacion(){
        return this.urbanizacion;
    }
    public String getnoApartamento(){
        return this.noApartamento;
    }
    public void setUrbanizacion(String urbanizacion){
        this.urbanizacion = urbanizacion;
    }
    public void setnoApartamento(String noApartamento){
        this.noApartamento = noApartamento;
    }

}
