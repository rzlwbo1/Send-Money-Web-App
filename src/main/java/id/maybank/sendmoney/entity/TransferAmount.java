package id.maybank.sendmoney.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "transfer")
public class TransferAmount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private LocalDateTime sendDate;
    @NotNull
    private Double amount;
    private Double fee = 0.0;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pengirim_id", referencedColumnName = "id")
    private Rekening rekPengirim;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "penerima_id", referencedColumnName = "id")
    private Rekening rekPenerima;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getSendDate() {
        return sendDate;
    }

    public void setSendDate(LocalDateTime sendDate) {
        this.sendDate = sendDate;
    }

    public Rekening getRekPengirim() {
        return rekPengirim;
    }

    public void setRekPengirim(Rekening rekPengirim) {
        this.rekPengirim = rekPengirim;
    }

    public Rekening getRekPenerima() {
        return rekPenerima;
    }

    public void setRekPenerima(Rekening rekPenerima) {
        this.rekPenerima = rekPenerima;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }
}
