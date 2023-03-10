package id.maybank.sendmoney.service.transfer;

import id.maybank.sendmoney.entity.Rekening;
import id.maybank.sendmoney.entity.TransferAmount;

import java.util.List;

public interface TransferService {

    List<TransferAmount> getAllTransfer();
    Boolean saveTransfer(TransferAmount transfer, Rekening rekPengirim, Rekening rekPenerima);

}
