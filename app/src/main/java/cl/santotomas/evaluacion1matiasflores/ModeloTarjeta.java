package cl.santotomas.evaluacion1matiasflores;

public class ModeloTarjeta {
    private int id;
    private String nombre;
    private String num_tarjeta;
    private String fecha;

    // constructores

    public ModeloTarjeta(int id, String nombre, String num_tarjeta, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.num_tarjeta = num_tarjeta;
        this.fecha = fecha;
    }

    public ModeloTarjeta() {
    }

    // ToString para printear/debuggear

    @Override
    public String toString() {
        return "ModeloTarjeta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", num_tarjeta='" + num_tarjeta + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }


    // getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNum_tarjeta() {
        return num_tarjeta;
    }

    public void setNum_tarjeta(String num_tarjeta) {
        this.num_tarjeta = num_tarjeta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
