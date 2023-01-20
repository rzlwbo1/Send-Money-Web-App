package id.maybank.sendmoney.service.nasabah;

import id.maybank.sendmoney.entity.Nasabah;
import id.maybank.sendmoney.entity.Provider;
import id.maybank.sendmoney.entity.Rekening;

import java.util.List;

public interface NasabahService {

    public List<Nasabah> getAllNasabah();
    void saveNasabah(Nasabah nasabah, Provider provider, Rekening rekening);

}
