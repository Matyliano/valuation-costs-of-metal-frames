package matyliano.valuation.client.controller;


import matyliano.valuation.client.model.Client;
import matyliano.valuation.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ClientListController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/clientlist")
    public String clientlist(Model model){
        List<Client> clients =  clientRepository.findAll();
        model.addAttribute( "clients",clients );
        return "client-list/client-list";
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent( @PathVariable("id") Long id, Model model) {
        clientRepository.delete(id);
        return "redirect:clientlist";
    }
}
