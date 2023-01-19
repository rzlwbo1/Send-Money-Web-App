package id.maybank.sendmoney.service.history;

import id.maybank.sendmoney.entity.HistoryTransfer;
import id.maybank.sendmoney.repository.HistoryRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void saveHistory(HistoryTransfer history) {
        this.historyRepo.save(history);
    }
}
