package id.maybank.sendmoney.service.transfer;

import id.maybank.sendmoney.entity.Rekening;
import id.maybank.sendmoney.entity.TransferAmount;
import id.maybank.sendmoney.repository.TransferRepo;
import id.maybank.sendmoney.service.history.HistoryService;
import id.maybank.sendmoney.service.rekening.RekeningService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TransferServiceImpl implements TransferService{

    @Autowired
    private TransferRepo transferRepo;
    @Autowired
    private RekeningService rekeningService;
    @Autowired
    private HistoryService historyService;

    @Override
    public List<TransferAmount> getAllTransfer() {
        return this.transferRepo.findAll();
    }

    @Override
    public Boolean saveTransfer(TransferAmount transfer, Rekening rekPengirim, Rekening rekPenerima) {

        // proses transfer dana

        Rekening rekeningPengirim = this.rekeningService.findByNoRek(rekPengirim.getNoRek());
        Rekening rekeningPenerima = this.rekeningService.findByNoRek(rekPenerima.getNoRek());
        Double takeAmount = transfer.getAmount();

        // check if beda bank
        String bankPengirim = rekeningPengirim.getProvider().getNamaBank();
        String bankPenerima = rekeningPenerima.getProvider().getNamaBank();

        // calculate
        Double saldoPengirim = rekeningPengirim.getSaldo();
        Double saldoPenerima = rekeningPenerima.getSaldo();

        // check if beda bank
        if (bankPengirim.equals(bankPenerima)) {

            Double minusSaldo = saldoPengirim - takeAmount;
            Double plusSaldo = saldoPenerima + takeAmount;

            // update saldo and send money
            // validasi saldo pengirim stelah transfer tidak boleh < 50.0000
            if (minusSaldo <= 50000.0) {
                System.out.println("Gagal Transfer");
                return false;
            } else {

                rekeningPengirim.setSaldo(minusSaldo);
                rekeningPenerima.setSaldo(plusSaldo);

                // update saldo masing" rekening
                this.rekeningService.saveTransferRek(rekeningPengirim, rekeningPenerima);

                //save ke transfer
                LocalDateTime dateTime = LocalDateTime.now();

                transfer.setSendDate(dateTime);
                transfer.setFee(0.0);
                transfer.setRekPengirim(rekPengirim);
                transfer.setRekPenerima(rekPenerima);

                this.transferRepo.save(transfer);

                // save to history
                this.historyService.saveHistory(rekeningPengirim, rekeningPenerima, transfer);
                return true;
            }

        } else {
            Double minusSaldo = (saldoPengirim - takeAmount) - 6500.0;
            Double plusSaldo = saldoPenerima + takeAmount;

            // update saldo and send money
            // validasi saldo pengirim stelah transfer tidak boleh < 50.0000
            if (minusSaldo <= 50000.0) {
                System.out.println("Gagal Transfer");
                return false;
            } else {
                rekeningPengirim.setSaldo(minusSaldo);
                rekeningPenerima.setSaldo(plusSaldo);

                // update saldo masing" rekening
                this.rekeningService.saveTransferRek(rekeningPengirim, rekeningPenerima);

                //save ke transfer
                LocalDateTime dateTime = LocalDateTime.now();

                transfer.setSendDate(dateTime);
                transfer.setFee(6500.0);
                transfer.setRekPengirim(rekPengirim);
                transfer.setRekPenerima(rekPenerima);

                this.transferRepo.save(transfer);

                // save to history
                this.historyService.saveHistory(rekeningPengirim, rekeningPenerima, transfer);
                return true;
            }

        }
        // end if else

    }

}
