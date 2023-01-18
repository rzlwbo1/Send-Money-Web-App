package id.maybank.sendmoney.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Rekening {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Column(unique = true)
    @Size(min = 5)
    private String noRek;

    private Double saldo = 700000.0;

    //// Relasi ke provider ///
    @ManyToOne
//    @JoinColumn(name = "provider_id")
    private Provider provider;

    //// Relasi ke nasabah ////
    @ManyToOne
//    @JoinColumn(name = "nasabah_id")
    private Nasabah nasabah;

    //// Relasi ke Transfer ///
    @OneToMany(mappedBy = "noRekening", fetch = FetchType.LAZY)
    private List<TransferAmount> transferAmounts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoRek() {
        return noRek;
    }

    public void setNoRek(String noRek) {
        this.noRek = noRek;
    }

    public Nasabah getNasabah() {
        return nasabah;
    }

    public void setNasabah(Nasabah nasabah) {
        this.nasabah = nasabah;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<TransferAmount> getTransferAmounts() {
        return transferAmounts;
    }

    public void setTransferAmounts(List<TransferAmount> transferAmounts) {
        this.transferAmounts = transferAmounts;
    }

}
