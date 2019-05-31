package matyliano.valuation.data.hourlyWage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HourlyWageController {

    @Autowired
    private HourlyWageRepository hourlyWageRepository;

    @GetMapping("/hourlyWage")
    public String price(Model model, Long id) {
        HourlyWage wage = hourlyWageRepository.findOne(id);
        model.addAttribute("hourlyWages", wage);
        return "hourlyWage";
    }


    @PostMapping(value = "/hourlyWage")
    public String submit(@Valid @ModelAttribute("hourlyWages") HourlyWage hourlyWage, BindingResult result, ModelMap modelMap){
        if(result.hasErrors()){
            return "error";
        }
        hourlyWageRepository.save(hourlyWage);
        return "hourlyWage";
    }

}
