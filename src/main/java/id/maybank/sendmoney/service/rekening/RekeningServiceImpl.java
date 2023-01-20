package id.maybank.sendmoney.service.rekening;

import id.maybank.sendmoney.entity.Rekening;
import id.maybank.sendmoney.repository.RekeningRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RekeningServiceImpl implements RekeningService{

    @Autowired
    private RekeningRepo rekeningRepo;

    @Override
    public List<Rekening> getAllRek() {
        return this.rekeningRepo.findAll();
    }

    @Override
    public void saveRekeing(Rekening rekening) {
        this.rekeningRepo.save(rekening);
    }

    @Override
    public Rekening findByNoRek(String noRek) {
        return this.rekeningRepo.findByNoRek(noRek);
    }

    @Override
    public void saveTransferRek(Rekening rekPengirim, Rekening rekPenerima) {
        this.rekeningRepo.save(rekPengirim);
        this.rekeningRepo.save(rekPenerima);
    }
}
