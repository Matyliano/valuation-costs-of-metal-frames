package matyliano.valuation.calculation;


import matyliano.valuation.calculation.operationTime.OperationTime;
import matyliano.valuation.calculation.operationTime.OperationTimeService;
import matyliano.valuation.calculation.totalTime.TotalTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@Controller
public class NewCalculationController {

    @Autowired
    private TotalTimeService totalTimeService;

    @Autowired
    private OperationTimeService operationTimeService;


    @GetMapping("/newcalculation")
    public String totalTime(Model model){
        model.addAttribute( "totalTime",totalTimeService.countingTotalOperationTime().getTotalTime());
        model.addAttribute( "operationTime",operationTimeService.getStartOperationTime().operationTime);
//        totalTimeService.countingTotalOperationTime().getTotalTime();
        return "calculation/newcalculation";
    }

    @PutMapping("/newcalculation")
    @ResponseStatus(HttpStatus.OK)
    public String operationTime( @Valid @ModelAttribute("operationTime") OperationTime operationTime, BindingResult bindingResult ){
        operationTimeService.operationTime(operationTime);
        return "calculation/newcalculation";

    }






}
