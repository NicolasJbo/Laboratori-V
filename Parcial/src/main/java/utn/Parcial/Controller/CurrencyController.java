package utn.Parcial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utn.Parcial.Model.Currency;
import utn.Parcial.Service.CurrencyService;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;
    //POST /currency
    @PostMapping
    public  void  addCurrency(@PathVariable String currency ,@PathVariable float monto){
        currencyService.addCurrency(currency,monto);
    }
    //GET /currency
    @GetMapping
    public List<Currency> getAll(){
        return currencyService.getAll();
    }
    //GET /currency/{id}
    @GetMapping("/{id}")
    public Currency getCurrencyById(@PathVariable Integer id ){
        return currencyService.getCurrencyById(id);
    }
    //DEL /currency
    @GetMapping("/remove/{id}")
    public void removeCurrencyById(@PathVariable Integer id){
        currencyService.removeById(id);
    }
}
