package ni.edu.uamv.proyectoOpenXava.modelo;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter @Setter
public class Producto {

    @Id
    @Column(length=10)
    private int id;

    @Column(length = 100, nullable = false)
    @Required
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @DescriptionsList
    private Categoria categoria;

    @Money
    private BigDecimal valor;

    @Files
    @Column(length = 32)
    private String foto;

    @TextArea
    private String observaciones;
}
