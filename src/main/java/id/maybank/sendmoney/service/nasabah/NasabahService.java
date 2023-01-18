package id.maybank.sendmoney.service.nasabah;

import id.maybank.sendmoney.entity.Nasabah;

import java.util.List;

public interface NasabahService {

    public List<Nasabah> getAllNasabah();
    void saveNasabah(Nasabah nasabah);

}
