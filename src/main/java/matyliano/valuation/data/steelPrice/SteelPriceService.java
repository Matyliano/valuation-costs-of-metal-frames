package matyliano.valuation.data.steelPrice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;


@Service
public class SteelPriceService {


    @Autowired
    SteelPriceRepository steelPriceRepository;


    public SteelPrice getLastValue() {

        List<SteelPrice> steelPriceList = steelPriceRepository.findAll();

        if (steelPriceList.size() == 0) {
            SteelPrice newSteelPrice = new SteelPrice();
            newSteelPrice.setStartDate(LocalDateTime.now());
            newSteelPrice.setSteelPrice(0.0);
            steelPriceList.add(newSteelPrice);
        }
        SteelPrice steelPrice = steelPriceList.get(steelPriceList.size() - 1);

        return steelPrice;
    }


    public SteelPrice updatePrice(SteelPrice newSteelPrice) {

        return steelPriceRepository.save(newSteelPrice);
    }

}
