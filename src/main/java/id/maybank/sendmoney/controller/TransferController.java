package id.maybank.sendmoney.controller;

import id.maybank.sendmoney.entity.HistoryTransfer;
import id.maybank.sendmoney.entity.Rekening;
import id.maybank.sendmoney.entity.TransferAmount;
import id.maybank.sendmoney.repository.TransferRepo;
import id.maybank.sendmoney.service.history.HistoryService;
import id.maybank.sendmoney.service.rekening.RekeningService;
import id.maybank.sendmoney.service.transfer.TransferService;
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

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private RekeningService rekeningService;
    @Autowired
    private TransferService transferService;
    @Autowired
    private HistoryService historyService;

    @GetMapping
    public String index(Model model) {
        List<Rekening> rekeningList1 = this.rekeningService.getAllRek();

        model.addAttribute("rekenings", rekeningList1);
        model.addAttribute("transfer", new TransferAmount());
        model.addAttribute("rekening", new Rekening());
        model.addAttribute("rekening2", new Rekening());


        // list data tf
        List<TransferAmount> transferList = this.transferService.getAllTransfer();
        model.addAttribute("transferList", transferList);

        return "transfer";
    }

    @PostMapping("/send")
    public String sendDana(@Valid @ModelAttribute("transfer") TransferAmount transfer,
                           BindingResult result,
                           @ModelAttribute("rekening") Rekening rekening,
                           @ModelAttribute("rekening2") Rekening rekening2,
                           RedirectAttributes attributes,
                           Model model) {

        if (result.hasErrors()) {
            List<Rekening> rekeningList = this.rekeningService.getAllRek();
            model.addAttribute("rekenings", rekeningList);
            model.addAttribute("rekening", rekening);
            model.addAttribute("rekening2", rekening2);
            model.addAttribute("transfer", transfer);

            List<TransferAmount> transferList = this.transferService.getAllTransfer();
            model.addAttribute("transferList", transferList);
            System.out.println("Error");
            return "transfer";
        }

        /// proses kirim
        Boolean statusTF = this.transferService.saveTransfer(transfer, rekening, rekening2);
        if (statusTF) {
            attributes.addFlashAttribute("message", "Berhasil Transfer");
        } else {
            attributes.addFlashAttribute("failed", "Gagal Transfer");
        }
        return "redirect:/transfer";
    }

}
