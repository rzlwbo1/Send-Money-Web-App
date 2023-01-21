package id.maybank.sendmoney.controller;

import id.maybank.sendmoney.entity.Rekening;
import id.maybank.sendmoney.service.rekening.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private RekeningService rekeningService;

    @GetMapping
    public String index() {
        return "home";
    }

    @GetMapping("/cek-rek/{norek}")
    public String cekRek(@PathVariable String norek, Model model) {

        Rekening infoRek = this.rekeningService.findByNoRek(norek);

        model.addAttribute("rekeningInfo", infoRek);
        return "cek-rekening";
    }

}
