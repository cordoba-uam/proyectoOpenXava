package calculadoras;

import javax.persistence.*;
import org.openxava.calculators.*;
import org.openxava.jpa.*;
import lombok.*;

@Getter @Setter
public class CalculadoraSiguienteNumeroParaAnio implements ICalculator{

    @Getter @Setter
    private int anio;

    @Override
    public Object calculate() throws Exception {

        Query query = XPersistence.getManager().createQuery("select max(f.numero) from Factura f where f.anio = :anio");

        query.setParameter("anio", anio);

        Integer ultimoNumero = (Integer) query.getSingleResult();
        return ultimoNumero == null ? 1 : ultimoNumero + 1;
    }
}
