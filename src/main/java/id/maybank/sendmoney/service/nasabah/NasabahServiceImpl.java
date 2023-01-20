package id.maybank.sendmoney.service.nasabah;

import id.maybank.sendmoney.entity.Nasabah;
import id.maybank.sendmoney.entity.Provider;
import id.maybank.sendmoney.entity.Rekening;
import id.maybank.sendmoney.repository.NasabahRepo;
import id.maybank.sendmoney.repository.RekeningRepo;
import id.maybank.sendmoney.service.rekening.RekeningService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class NasabahServiceImpl implements NasabahService{

    @Autowired
    private NasabahRepo nasabahRepo;
    @Autowired
    private RekeningService rekeningService;


    @Override
    public List<Nasabah> getAllNasabah() {
        return this.nasabahRepo.findAll();
    }

    @Override
    public void saveNasabah(Nasabah nasabah, Provider provider, Rekening rekening) {

        this.nasabahRepo.save(nasabah);
        rekening.setNasabah(nasabah);
        rekening.setProvider(provider);
        this.rekeningService.saveRekeing(rekening);

    }

}
