package id.maybank.sendmoney.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String namaBank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rekening_id")
    private Rekening rekening;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBank() {
        return namaBank;
    }

    public void setBank(String namaBank) {
        this.namaBank = namaBank;
    }

    public Rekening getRekening() {
        return rekening;
    }

    public void setRekening(Rekening rekening) {
        this.rekening = rekening;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "namaBank='" + namaBank + '\'' +
                ", rekening=" + rekening +
                '}';
    }
}
