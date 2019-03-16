package matyliano.valuation.data;


import matyliano.valuation.data.euro.EuroService;
import matyliano.valuation.data.hourlyWage.HourlyWage;
import matyliano.valuation.data.hourlyWage.HourlyWageService;
import matyliano.valuation.data.steelPrice.SteelPrice;
import matyliano.valuation.data.steelPrice.SteelPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
public class DataController {

    @Autowired
    private HourlyWageService hourlyWageService;

    @Autowired
    private EuroService euroService;

    @Autowired
    private SteelPriceService steelPriceService;

    @GetMapping("/data")
    @ResponseStatus(HttpStatus.OK)
    public String data(Model model) throws IOException {

        List<HourlyWage> hourlyWages = hourlyWageService.getHourlyWageList();

        model.addAttribute("hourlyWage", hourlyWages);
        model.addAttribute("euro", euroService.euroLastApplicableValue());
        model.addAttribute("price", steelPriceService.getLastValue());
        return "data/data";
    }

    @GetMapping("/price")
    public String priceChange(Model model) {
        model.addAttribute("steelPrice", steelPriceService.getLastValue());
        return "data/price";
    }

    @PostMapping("/price")
    @ResponseStatus(HttpStatus.CREATED)
    public String updatePriceOfSteel(@Valid @ModelAttribute("steelPrice") SteelPrice steelPrice){
        System.out.println(steelPrice.getId());
        System.out.println(steelPrice.getSteelPrice());
//        System.out.println(steelPrice.getStartDate());
//        System.out.println(steelPrice.getEndDate());

        steelPriceService.updatePrice(steelPrice);
        return "data/price";
    }

    @GetMapping("/time-consuming")
    public String hourlyWage(Model model){
        model.addAttribute("hourlyWage", hourlyWageService);

        return "data/hourlyWage";
    }

    @PostMapping("/time-consuming")
    @ResponseStatus(HttpStatus.CREATED)
    public String addWorkToHourlyWage(@Valid @ModelAttribute("hourlyWage") HourlyWage work, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "general";
        }

        hourlyWageService.updateHourlyWage(work);

        return "data/data";
    }

}