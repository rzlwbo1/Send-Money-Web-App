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

    //// Relasi ke provider ///
    @OneToMany(mappedBy = "rekening", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Provider> providers;

    //// Relasi ke nasabah ////
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nasabah_id")
    private Nasabah nasabah;

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
}
