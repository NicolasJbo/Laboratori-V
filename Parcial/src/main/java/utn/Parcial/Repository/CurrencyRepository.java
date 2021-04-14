package utn.Parcial.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.Parcial.Model.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Integer> {

}
