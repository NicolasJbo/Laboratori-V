package utn.Parcial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import utn.Parcial.Model.Currency;
import utn.Parcial.Repository.CurrencyRepository;

import java.util.List;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    public void addCurrency(String currency, float monto) {
        Currency cur= new Currency(currency,monto);
        currencyRepository.save(cur);
    }

    public List<Currency> getAll() {
        return currencyRepository.findAll();
    }


    public Currency getCurrencyById(Integer id) {
        return currencyRepository.findById(id).orElseThrow(()->new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void removeById(Integer id) {
        currencyRepository.deleteById(id);
    }
}
