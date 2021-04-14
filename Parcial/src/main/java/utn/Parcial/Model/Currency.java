package utn.Parcial.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Currency {

    public Currency(String currency, float monto) {
        this.currency = currency;
        this.monto = monto;
    }

    @Id
    private int id;
    private String currency;
    private float monto;


}
