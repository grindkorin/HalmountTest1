package haulmontTest1.controller;

import haulmontTest1.entity.Apartments;
import haulmontTest1.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/apartments")
public class ApartmentsController {

    @Autowired
    ApartmentService service;

    @GetMapping("/apartments")
    public String apartments(ModelMap model) {
        model.put("apartments", service.findAll());
        model.put("apartmentsFree", service.findAllFree());
        model.put("apartmentsOccupied", service.findAllByOccupiedTrue());
        model.put("apartmentsBooked", service.findAllByBookedTrue());
        return "apartments";
    }

    @GetMapping("/getById")
    @ResponseBody
    public Apartments getById(Long id) {
        return service.getById(id);
    }

    @PostMapping("/save")
    public String save(Apartments apartments) {
        service.save(apartments);
        return "redirect:apartments";
    }

    @GetMapping("/delete")
    public String delete(Long id) {
        service.deleteById(id);
        return "redirect:/apartments";
    }

}
