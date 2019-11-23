package dataservice;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "##default", propOrder = {
        "txnId",
        "nasabahId",
        "jenisTxn",
        "amount",
        "noAcc",
        "dateTime"
})

@XmlRootElement(name = "")
public class Transaksi {
    @XmlElement(name = "txnId", required = true)
    private int txnId;
    @XmlElement(name = "nasabahId", required = true)
    private int nasabahId;
    @XmlElement(name = "jenisTxn", required = true)
    private String jenisTxn;
    @XmlElement(name = "amount", required = true)
    private int amount;
    @XmlElement(name = "noAcc", required = true)
    private String noAcc;
    @XmlElement(name = "dateTime", required = true)
    private String dateTime;

    public int getTxnId() {
        return txnId;
    }

    public void setNasabahId(int nasabahId) {
        this.nasabahId = nasabahId;
    }

    public int getNasabahId() {
        return nasabahId;
    }

    public void setJenisTxn(String jenisTxn) {
        this.jenisTxn = jenisTxn;
    };

    public String getJenisTxn() {
        return jenisTxn;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    };

    public int getAmount() {
        return amount;
    }

    public void getDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String setDataTime() {
        return dateTime;
    }

}
