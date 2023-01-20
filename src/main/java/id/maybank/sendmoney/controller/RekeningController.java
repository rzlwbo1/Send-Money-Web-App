package id.maybank.sendmoney.controller;

import id.maybank.sendmoney.entity.Nasabah;
import id.maybank.sendmoney.entity.Provider;
import id.maybank.sendmoney.entity.Rekening;
import id.maybank.sendmoney.service.nasabah.NasabahService;
import id.maybank.sendmoney.service.provider.ProviderService;
import id.maybank.sendmoney.service.rekening.RekeningService;
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
    private NasabahService nasabahService;
    @Autowired
    private RekeningService rekeningService;
    @Autowired
    private ProviderService providerService;

    @GetMapping
    public String index(Model model) {

        // list data;
        List<Rekening> rekeningList = this.rekeningService.getAllRek();
//        System.out.println(rekeningList.get(0).getNasabah().getFullName());

        model.addAttribute("rekeningsList", rekeningList);
        return "rekening";
    }

    @GetMapping("/form-rekening")
    public String formRek(Model model) {

        /// untuk form
        model.addAttribute("nasabah" , new Nasabah());
        model.addAttribute("rekening", new Rekening());
        model.addAttribute("provider", new Provider());

        List<Provider> providerList = this.providerService.getAllBank();
        model.addAttribute("providers", providerList);

        return "form-rekening";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("nasabah") Nasabah nasabah,
                       BindingResult result,
                       @Valid @ModelAttribute("rekening") Rekening rekening,
                       BindingResult result2,
                       @ModelAttribute("provider") Provider provider,
                       Model model) {

        if (result.hasErrors() || result2.hasErrors()) {

            model.addAttribute("nasabah" , nasabah);
            model.addAttribute("rekening", rekening);
            model.addAttribute("provider", provider);

            List<Provider> providerList = this.providerService.getAllBank();
            model.addAttribute("providers", providerList);

            return "form-rekening";
        }

        this.nasabahService.saveNasabah(nasabah, provider, rekening);

        return "redirect:/rekening";
    }

}
