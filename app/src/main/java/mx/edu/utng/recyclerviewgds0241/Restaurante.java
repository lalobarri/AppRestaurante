package mx.edu.utng.recyclerviewgds0241;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Restaurante {
    //Clase POJO Objeto simple de Java
    @PrimaryKey
    @NonNull
    private String nombre;
    private String urlPhoto;
    private float valoracion;
    private String direccion;

    //Constructor con los cuatro parámetros
    public Restaurante() {

    }
    //Método Getter y Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
