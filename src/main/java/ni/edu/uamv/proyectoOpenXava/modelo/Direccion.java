package ni.edu.uamv.proyectoOpenXava.modelo;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

@Embeddable
@Getter @Setter
public class Direccion {

    @Column(length = 30)
    private String viaPublica;

    @Column(length = 5)
    private int codigoPostal;

    @Column(length = 20)
    private String municipio;

    @Column(length = 30)
    private String provincia;
}
