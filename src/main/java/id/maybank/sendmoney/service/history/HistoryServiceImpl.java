package id.maybank.sendmoney.service.history;

import id.maybank.sendmoney.entity.HistoryTransfer;
import id.maybank.sendmoney.entity.Rekening;
import id.maybank.sendmoney.entity.TransferAmount;
import id.maybank.sendmoney.repository.HistoryRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class HistoryServiceImpl implements HistoryService{

    @Autowired
    private HistoryRepo historyRepo;

    @Override
    public List<HistoryTransfer> getAllHistories() {
        return this.historyRepo.findAll();
    }

    @Override
    public void saveHistory(Rekening rekPengirim, Rekening rekPenerima, TransferAmount transferAmount) {
        LocalDateTime dateTime = LocalDateTime.now();

        HistoryTransfer historyTransfer = new HistoryTransfer();
        historyTransfer.setRekPengirim(rekPengirim.getNoRek());
        historyTransfer.setRekPenerima(rekPenerima.getNoRek());
        historyTransfer.setSendDate(dateTime);
        historyTransfer.setAmountTransfer(transferAmount.getAmount());

        this.historyRepo.save(historyTransfer);
    }

}
