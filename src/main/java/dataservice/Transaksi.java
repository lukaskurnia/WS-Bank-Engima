package dataservice;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "##default", propOrder = {
        "status",
        "jenisTxn",
        "amount",
        "noAcc",
        "transactionTime"
})

@XmlRootElement(name = "")
public class Transaksi {
    @XmlElement(name = "jenisTxn", required = true)
    private List<String> jenisTxn;
    @XmlElement(name = "amount", required = true)
    private List<String> amount;
    @XmlElement(name = "noAcc", required = true)
    private List<String> noAcc;
    @XmlElement(name = "transactionTime", required = true)
    private List<String> transactionTime;
    @XmlElement(name = "status", required = true)
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setJenisTxn(List<String> jenisTxn) {
        this.jenisTxn = jenisTxn;
    };

    public List<String> getJenisTxn() {
        return jenisTxn;
    }

    public void setAmount(List<String> amount) {
        this.amount = amount;
    };

    public List<String> getAmount() {
        return amount;
    }

    public void setTransactionTime(List<String> transactionTime) {
        this.transactionTime = transactionTime;
    }

    public List<String> getTransactionTime() {
        return transactionTime;
    }

    public void setNoAcc(List<String> noAcc) {
        this.noAcc = noAcc;
    }

    public List<String> getNoAcc() {
        return noAcc;
    }

}
