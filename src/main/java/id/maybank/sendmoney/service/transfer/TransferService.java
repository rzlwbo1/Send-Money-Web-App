package id.maybank.sendmoney.service.transfer;

import id.maybank.sendmoney.entity.TransferAmount;

import java.util.List;

public interface TransferService {

    List<TransferAmount> getAllTransfer();

    void saveTransfer(TransferAmount transfer);

}
