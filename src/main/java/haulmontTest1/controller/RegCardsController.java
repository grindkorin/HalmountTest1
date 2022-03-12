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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("/regCard")
public class RegCardsController {
    @Autowired
    RegistrationCardService cardService;
    @Autowired
    ClientService clientService;

    @GetMapping("/regCard")
    public String cardById(@RequestParam("id") Long id, ModelMap map) {
        List<RegistrationCard> all = cardService.findAllByClient(clientService.getClientById(id));
        cardService.allCardsCheck(all);
        map.put("cards", all);
        map.addAttribute("message", " пользователя " + clientService.getClientById(id).getName());
        return "reg_cards";
    }

    @GetMapping("/regCard/findId")
    @ResponseBody
    public RegistrationCard getById(Long id) {
        return cardService.getById(id);
    }

    @PostMapping("/saveRegCard")
    public String saveReg(RegistrationCardDto dto) {
        cardService.save(cardService.fromDto(dto));
        return "redirect:/regCard/" + "?id=" + dto.getClientId().toString();
    }
}
