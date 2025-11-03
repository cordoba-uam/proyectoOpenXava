package ni.edu.uamv.proyectoOpenXava.modelo;

import java.time.*;
import java.util.Collection;
import javax.persistence.*;

import calculadoras.CalculadoraSiguienteNumeroParaAnio;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import lombok.*;

@Entity
@Setter @Getter
public class Factura {

    @Id
    @Hidden
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column (length = 32)
    private String id;

    @Column (length = 4)
    @DefaultValueCalculator(CurrentYearCalculator.class)
    private String anio;

    @Column (length = 6)
    @DefaultValueCalculator(value= CalculadoraSiguienteNumeroParaAnio.class, properties= @PropertyValue(name="anio"))
    private int numero;

    @Required
    @DefaultValueCalculator(CurrentYearCalculator.class)
    private LocalDate fecha;

    @TextArea
    String observaciones;

    @ManyToOne(fetch=FetchType.LAZY, optional=false) // El cliente es obligatorio
    Cliente cliente;

    @ElementCollection
    @ListProperties("producto.numero, producto.descripcion, cantidad")
    Collection<Detalle> detalles;
}
