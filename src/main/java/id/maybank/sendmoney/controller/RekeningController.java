package id.maybank.sendmoney.controller;

import id.maybank.sendmoney.entity.Nasabah;
import id.maybank.sendmoney.entity.Provider;
import id.maybank.sendmoney.entity.Rekening;
import id.maybank.sendmoney.repository.NasabahRepo;
import id.maybank.sendmoney.repository.ProviderRepo;
import id.maybank.sendmoney.repository.RekeningRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rekening")
public class RekeningController {

    @Autowired
    private NasabahRepo nasabahRepo;
    @Autowired
    private RekeningRepo rekeningRepo;
    @Autowired
    private ProviderRepo providerRepo;

    @GetMapping
    public String index(Model model) {

        model.addAttribute("nasabah" , new Nasabah());
        model.addAttribute("rekening", new Rekening());
        model.addAttribute("provider", new Provider());
        return "rekening";
    }

    @PostMapping("/save")
    public String save(@Valid Nasabah nasabah, Rekening rekening, Provider provider) {

        System.out.println(nasabah.toString());
        System.out.println(rekening.toString());
        System.out.println(provider.toString());

        return "redirect:/rekening";
    }

}
