package id.maybank.sendmoney.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "history")
public class HistoryTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rekPenerima;
    private String rekPengirim;
    private Date sendDate;

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

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
}
