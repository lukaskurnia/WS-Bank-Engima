package dataservice;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "##default", propOrder = {
        "nasabahId",
        "virtualAcc"
})

@XmlRootElement(name = "Testing3")
public class VirtualAcc {
    @XmlElement(name = "nasabahId", required = true)
    private int nasabahId;
    @XmlElement(name = "virtualAcc", required = true)
    private String virtualAcc;

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
