package id.maybank.sendmoney.controller;

import id.maybank.sendmoney.entity.Rekening;
import id.maybank.sendmoney.entity.TransferAmount;
import id.maybank.sendmoney.repository.TransferRepo;
import id.maybank.sendmoney.service.rekening.RekeningService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
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
    private TransferRepo transferRepo;

    @GetMapping
    public String index(Model model) {
        List<Rekening> rekeningList1 = this.rekeningService.getAllRek();

        model.addAttribute("rekenings", rekeningList1);
        model.addAttribute("transfer", new TransferAmount());
        model.addAttribute("rekening", new Rekening());
        model.addAttribute("rekening2", new Rekening());


        // list data tf
        List<TransferAmount> transferList = this.transferRepo.findAll();
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

            List<TransferAmount> transferList = this.transferRepo.findAll();
            model.addAttribute("transferList", transferList);
            System.out.println("Error");
            return "transfer";
        }


        /// proses kirim
        // validasi saldo pengirim stelah transfer tidak boleh < 50.0000

        Rekening rekPengirim = this.rekeningService.findByNoRek(rekening.getNoRek());
        Rekening rekPenerima = this.rekeningService.findByNoRek(rekening2.getNoRek());
        Double takeAmount = transfer.getAmount();

        // check if beda bank
        String bankPengirim = rekPengirim.getProvider().getNamaBank();
        String bankPenerima = rekPenerima.getProvider().getNamaBank();

        System.out.println(bankPengirim);
        System.out.println(bankPenerima);

        // calculate
        Double saldoPengirim = rekPengirim.getSaldo();
        Double saldoPenerima = rekPenerima.getSaldo();


        if (bankPengirim.equals(bankPenerima)) {

            Double minusSaldo = saldoPengirim - takeAmount;
            Double plusSaldo = saldoPenerima + takeAmount;

            // update saldo

            if (minusSaldo <= 50000.0) {
                attributes.addFlashAttribute("failed", "Gagal Tansfer");
                System.out.println("Gagal Transfer");
            } else {

                rekPengirim.setSaldo(minusSaldo);
                rekPenerima.setSaldo(plusSaldo);

                this.rekeningService.saveRekeing(rekPengirim);
                this.rekeningService.saveRekeing(rekPenerima);

                //save ke transfer
                LocalDateTime dateTime = LocalDateTime.now();

                transfer.setSendDate(dateTime);
                transfer.setFee(0.0);
                transfer.setRekPengirim(rekening);
                transfer.setRekPenerima(rekening2);

                attributes.addFlashAttribute("message", "Berhasil Transfer");
                this.transferRepo.save(transfer);
            }

        } else {
            Double minusSaldo = (saldoPengirim - takeAmount) - 6500.0;
            Double plusSaldo = saldoPenerima + takeAmount;

            // update saldo

            if (minusSaldo <= 50000.0) {
                attributes.addFlashAttribute("failed", "Gagal Tansfer");
                System.out.println("Gagal Transfer");
            } else {
                rekPengirim.setSaldo(minusSaldo);
                rekPenerima.setSaldo(plusSaldo);

                this.rekeningService.saveRekeing(rekPengirim);
                this.rekeningService.saveRekeing(rekPenerima);

                //save ke transfer
                LocalDateTime dateTime = LocalDateTime.now();

                transfer.setSendDate(dateTime);
                transfer.setFee(6500.0);
                transfer.setRekPengirim(rekening);
                transfer.setRekPenerima(rekening2);

                attributes.addFlashAttribute("message", "Berhasil Transfer");
                this.transferRepo.save(transfer);
            }

        }
        return "redirect:/transfer";
    }

}
