package id.maybank.sendmoney.controller;

import id.maybank.sendmoney.entity.Provider;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/bank")
public class AdminController {
    @Autowired
    private ProviderService providerService;

    @GetMapping
    public String index(Model model) {

        List<Provider> providers = this.providerService.getAllBank();
        Collections.reverse(providers); // sorting dari yang terbaru

        model.addAttribute("bankForm", new Provider());
        model.addAttribute("banks", providers);
        System.out.println(providers);
        return "banks";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("bankForm") Provider bankForm,
                       BindingResult result,
                       RedirectAttributes attributes,
                       Model model) {

        if (result.hasErrors()) {
            List<Provider> providers = this.providerService.getAllBank();
            model.addAttribute("bankForm", bankForm);
            model.addAttribute("banks", providers);
            return "banks";
        }

        this.providerService.savebank(bankForm);
        attributes.addFlashAttribute("success", "Berhasil tambah bank");
        return "redirect:/bank";
    }

}
