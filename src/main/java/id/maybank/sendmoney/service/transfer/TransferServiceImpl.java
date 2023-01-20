package id.maybank.sendmoney.service.transfer;

import id.maybank.sendmoney.entity.TransferAmount;
import id.maybank.sendmoney.repository.TransferRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TransferServiceImpl implements TransferService{

    @Autowired
    private TransferRepo transferRepo;

    @Override
    public List<TransferAmount> getAllTransfer() {
        return this.transferRepo.findAll();
    }

    @Override
    public void saveTransfer(TransferAmount transfer) {
        this.transferRepo.save(transfer);
    }
}
