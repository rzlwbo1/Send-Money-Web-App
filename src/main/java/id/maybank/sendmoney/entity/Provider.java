package id.maybank.sendmoney.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String namaBank;

    @OneToMany(mappedBy = "provider", fetch = FetchType.LAZY)
    private List<Rekening> rekenings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaBank() {
        return namaBank;
    }

    public void setNamaBank(String namaBank) {
        this.namaBank = namaBank;
    }

    public List<Rekening> getRekenings() {
        return rekenings;
    }

    public void setRekenings(List<Rekening> rekenings) {
        this.rekenings = rekenings;
    }

}
