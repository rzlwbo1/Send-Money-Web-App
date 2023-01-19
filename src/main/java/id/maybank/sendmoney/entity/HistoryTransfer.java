package id.maybank.sendmoney.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "history")
public class HistoryTransfer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rekPenerima;
    private String rekPengirim;
    private LocalDateTime sendDate;
    private Double amountTransfer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRekPenerima() {
        return rekPenerima;
    }

    public void setRekPenerima(String rekPenerima) {
        this.rekPenerima = rekPenerima;
    }

    public String getRekPengirim() {
        return rekPengirim;
    }

    public void setRekPengirim(String rekPengirim) {
        this.rekPengirim = rekPengirim;
    }

    public LocalDateTime getSendDate() {
        return sendDate;
    }

    public void setSendDate(LocalDateTime sendDate) {
        this.sendDate = sendDate;
    }

    public Double getAmountTransfer() {
        return amountTransfer;
    }

    public void setAmountTransfer(Double amountTransfer) {
        this.amountTransfer = amountTransfer;
    }
}
