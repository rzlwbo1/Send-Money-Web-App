package id.maybank.sendmoney.service.history;

import id.maybank.sendmoney.entity.HistoryTransfer;
import id.maybank.sendmoney.entity.Rekening;
import id.maybank.sendmoney.entity.TransferAmount;

import java.util.List;

public interface HistoryService {

    List<HistoryTransfer> getAllHistories();
    void saveHistory(Rekening rekPengirim, Rekening rekPenerima, TransferAmount transferAmount);

}
