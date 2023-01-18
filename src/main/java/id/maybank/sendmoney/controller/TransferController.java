package id.maybank.sendmoney.controller;

import id.maybank.sendmoney.entity.Rekening;
import id.maybank.sendmoney.entity.TransferAmount;
import id.maybank.sendmoney.repository.TransferRepo;
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

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private RekeningService rekeningService;
    @Autowired
    private TransferRepo transferRepo;

    @GetMapping
    public String index(Model model) {
        List<Rekening> rekeningList1 = this.rekeningService.getAllRek();

        model.addAttribute("rekenings", rekeningList1);
        model.addAttribute("transfer", new TransferAmount());
        model.addAttribute("rekening", new Rekening());

        return "transfer";
    }

    @PostMapping("/send")
    public String sendDana(@ModelAttribute("transfer") TransferAmount transfer,
                           @ModelAttribute("rekening") Rekening rekening,
                           BindingResult result,
                           Model model) {

//        if (result.hasErrors()) {
//            List<Rekening> rekeningList = this.rekeningService.getAllRek();
//            model.addAttribute("rekeningPengirim", rekeningList);
//            model.addAttribute("rekeningPenerima", rekeningList);
//            model.addAttribute("transfer", transfer);
//            System.out.println("Error");
//            return "transfer";
//        }

        System.out.println(rekening.getNoRek());
        System.out.println(transfer.getAmount());

        LocalDateTime dateTime = LocalDateTime.now();


        return "redirect:/transfer";
    }

}
