package id.maybank.sendmoney.service.nasabah;

import id.maybank.sendmoney.entity.Nasabah;
import id.maybank.sendmoney.repository.NasabahRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class NasabahServiceImpl implements NasabahService{

    @Autowired
    private NasabahRepo nasabahRepo;


    @Override
    public List<Nasabah> getAllNasabah() {
        return this.nasabahRepo.findAll();
    }

    @Override
    public void saveNasabah(Nasabah nasabah) {
        this.nasabahRepo.save(nasabah);
    }
}
