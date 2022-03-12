package haulmontTest1.controller;

import haulmontTest1.adapter.RegistrationCardDto;
import haulmontTest1.entity.RegistrationCard;
import haulmontTest1.service.BookingService;
import haulmontTest1.service.RegistrationCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;
    @Autowired
    RegistrationCardService cardService;

    @GetMapping("/booking")
    public String booking() {
        return "booking";
    }

    @PostMapping("/newBooking")
    public String newBooking(@ModelAttribute RegistrationCardDto card,
                             Model model) {
        try {
            RegistrationCard cardDb = bookingService.bookedCard(card);
            if (bookingService.brandNewCard(card, cardDb)) {
                cardService.save(cardDb);
            }
            return "redirect:/clients";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", e.getMessage());
            return "booking";
        }
    }

}
