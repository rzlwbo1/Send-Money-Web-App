package id.maybank.sendmoney.service.rekening;

import id.maybank.sendmoney.entity.Rekening;

import java.util.List;
import java.util.Optional;

public interface RekeningService {

    public List<Rekening> getAllRek();
    void saveRekeing(Rekening rekening);
    Rekening findByNoRek(String noRek);
    void saveTransferRek(Rekening rekPengirim, Rekening rekPenerima);

}
