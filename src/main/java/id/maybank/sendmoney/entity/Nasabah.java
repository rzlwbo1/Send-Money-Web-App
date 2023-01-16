package id.maybank.sendmoney.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
public class Nasabah {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min = 3)
    private String fullName;
    private Date dob;
    private String noIdentitas;
    private String tipeIdentias;
    private String email;
    private String noContact;

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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getNoIdentitas() {
        return noIdentitas;
    }

    public void setNoIdentitas(String noIdentitas) {
        this.noIdentitas = noIdentitas;
    }

    public String getTipeIdentias() {
        return tipeIdentias;
    }

    public void setTipeIdentias(String tipeIdentias) {
        this.tipeIdentias = tipeIdentias;
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

    @Override
    public String toString() {
        return "Nasabah{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", noIdentitas='" + noIdentitas + '\'' +
                ", tipeIdentias='" + tipeIdentias + '\'' +
                ", email='" + email + '\'' +
                ", noContact='" + noContact + '\'' +
                '}';
    }
}
