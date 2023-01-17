package id.maybank.sendmoney.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Nasabah{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 3)
    private String fullName;
    private LocalDate dob;
    private String noIdentitas;
    private String tipeIdentitas;
    private String email;
    private String noContact;


    //// Relasi ke rekening ////
    @OneToMany(mappedBy = "nasabah", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rekening> rekenings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getNoIdentitas() {
        return noIdentitas;
    }

    public void setNoIdentitas(String noIdentitas) {
        this.noIdentitas = noIdentitas;
    }

    public String getTipeIdentitas() {
        return tipeIdentitas;
    }

    public void setTipeIdentitas(String tipeIdentitas) {
        this.tipeIdentitas = tipeIdentitas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoContact() {
        return noContact;
    }

    public void setNoContact(String noContact) {
        this.noContact = noContact;
    }

    public List<Rekening> getRekenings() {
        return rekenings;
    }

    public void setRekenings(List<Rekening> rekenings) {
        this.rekenings = rekenings;
    }

    @Override
    public String toString() {
        return "Nasabah{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", noIdentitas='" + noIdentitas + '\'' +
                ", tipeIdentias='" + tipeIdentitas + '\'' +
                ", email='" + email + '\'' +
                ", noContact='" + noContact + '\'' +
                '}';
    }
}
