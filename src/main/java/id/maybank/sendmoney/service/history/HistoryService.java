package id.maybank.sendmoney.service.history;

import id.maybank.sendmoney.entity.HistoryTransfer;

import java.util.List;

public interface HistoryService {

    List<HistoryTransfer> getAllHistories();
    void saveHistory(HistoryTransfer history);

}
