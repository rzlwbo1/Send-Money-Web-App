package id.maybank.sendmoney.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Rekening {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Column(unique = true)
    @Size(min = 5)
    private String noRek;

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
}
