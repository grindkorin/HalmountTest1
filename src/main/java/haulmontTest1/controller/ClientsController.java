package haulmontTest1.controller;


import haulmontTest1.adapter.ClientDto;
import haulmontTest1.entity.Client;
import haulmontTest1.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/clients")
public class ClientsController {

    @Autowired
    ClientService service;


    @GetMapping("/clients")
    public String clients(ModelMap modelMap) {
        modelMap.put("clients", service.findAllClients());
        return "clients";
    }

    @PostMapping("/saveClient")
    public String save(ClientDto dto) {
        service.saveClient(service.fromDto(dto));
        return "redirect:clients";
    }

    @GetMapping("/findById")
    @ResponseBody
    public Client getById(Long id) {
        return service.getClientById(id);
    }

    @GetMapping("/deleteClient")
    public String delete(Long id) {
        service.deleteClientById(id);
        return "redirect:/clients";
    }
}
