package dataservice;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "##default", propOrder = {
        "status",
        "noAcc"
})

@XmlRootElement(name = "Testing4")
public class AccountNumber {
    @XmlElement(name = "noAcc", required = true)
    private String noAcc;
    @XmlElement(name = "status", required = true)
    private int status;


    public int setStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public String getNoAcc() {
        return noAcc;
    }

}
