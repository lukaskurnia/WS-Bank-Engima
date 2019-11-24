package dataservice;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "##default", propOrder = {
        "status",
        "virtualAcc",
        "nasabahId"
})

@XmlRootElement(name = "")
public class VirtualAcc {
    @XmlElement(name = "nasabahId", required = true)
    private int nasabahId;
    @XmlElement(name = "virtualAcc", required = true)
    private String virtualAcc;
    @XmlElement(name = "status", required = true)
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public void setNasabahId(int nasabahId) {
        this.nasabahId = nasabahId;
    }

    public int getNasabahId() {
        return nasabahId;
    }

    public void setAmount(String virtualAcc) {
        this.virtualAcc = virtualAcc;
    };

    public String getAmount() {
        return virtualAcc;
    }


}
