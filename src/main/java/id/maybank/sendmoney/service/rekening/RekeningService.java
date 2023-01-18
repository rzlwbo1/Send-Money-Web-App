package id.maybank.sendmoney.service.rekening;

import id.maybank.sendmoney.entity.Rekening;

import java.util.List;

public interface RekeningService {

    public List<Rekening> getAllRek();
    void saveRekeing(Rekening rekening);

}
