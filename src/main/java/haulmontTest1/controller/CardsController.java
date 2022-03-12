package haulmontTest1.controller;

import haulmontTest1.adapter.RegistrationCardDto;
import haulmontTest1.entity.RegistrationCard;
import haulmontTest1.service.ClientService;
import haulmontTest1.service.RegistrationCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("/cards")
public class CardsController {

    @Autowired
    RegistrationCardService cardService;
    @Autowired
    ClientService clientService;

    @GetMapping("/cards")
    public String home(ModelMap map) {
        List<RegistrationCard> all = cardService.findAll();
        cardService.allCardsCheck(all);
        map.put("cards", all);
        return "cards";
    }

    @GetMapping("/findCardById")
    @ResponseBody
    public RegistrationCard getById(Long id) {
        return cardService.getById(id);
    }

    @PostMapping("/saveCard")
    public String save(RegistrationCardDto dto) {
        cardService.save(cardService.fromDto(dto));
        return "redirect:cards";
    }

    @GetMapping("/deleteCard")
    public String delete(Long id) {
        cardService.deleteById(id);
        return "redirect:/cards";
    }

}
