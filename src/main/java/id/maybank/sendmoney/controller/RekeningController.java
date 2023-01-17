package id.maybank.sendmoney.controller;

import id.maybank.sendmoney.entity.Nasabah;
import id.maybank.sendmoney.entity.Provider;
import id.maybank.sendmoney.entity.Rekening;
import id.maybank.sendmoney.repository.NasabahRepo;
import id.maybank.sendmoney.repository.RekeningRepo;
import id.maybank.sendmoney.service.provider.ProviderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rekening")
public class RekeningController {

    @Autowired
    private NasabahRepo nasabahRepo;
    @Autowired
    private RekeningRepo rekeningRepo;
    @Autowired
    private ProviderService providerService;

    @GetMapping
    public String index(Model model) {

        model.addAttribute("nasabah" , new Nasabah());
        model.addAttribute("rekening", new Rekening());
        model.addAttribute("provider", new Provider());

        List<Provider> providerList = this.providerService.getAllBank();
        model.addAttribute("providers", providerList);

        return "rekening";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("nasabah") Nasabah nasabah,
                       @ModelAttribute("rekening") Rekening rekening,
                       @ModelAttribute("provider") Provider provider,
                       BindingResult result,
                       Model model) {

        if (result.hasErrors()) {

            model.addAttribute("nasabah" , nasabah);
            model.addAttribute("rekening", rekening);
            model.addAttribute("provider", provider);

            return "rekening";
        }

//        System.out.println(nasabah.toString());
//        System.out.println(rekening.toString());
//        System.out.println(provider.toString());


//        this.nasabahRepo.save(nasabah);
//        rekening.setNasabah(nasabah);
//        rekening.setProvider(provider);
//        this.rekeningRepo.save(rekening);

//        List<Rekening> rekenings = new ArrayList<>();
//        rekenings.add(rekening);
//
//        nasabah.setRekenings(rekenings);
//        rekening.setNasabah(nasabah);
        this.nasabahRepo.save(nasabah);
        rekening.setNasabah(nasabah);
        this.rekeningRepo.save(rekening);

        return "redirect:/rekening";
    }

}
