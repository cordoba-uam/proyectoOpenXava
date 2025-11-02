package ni.edu.uamv.proyectoOpenXava.modelo;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

@Entity
@Getter @Setter
public class Cliente {

    @Id
    @Column(length=10)
    private int id;

    @Column(length = 100, nullable = false)
    @Required
    private String nombre;

    @Embedded @NoFrame
    private Direccion direccion;
}
