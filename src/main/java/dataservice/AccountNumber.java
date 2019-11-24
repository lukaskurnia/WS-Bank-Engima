package dataservice;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "##default", propOrder = {
        "status",
        "noAcc"
})

@XmlRootElement(name = "")
public class AccountNumber {
    @XmlElement(name = "noAcc", required = true)
    private String noAcc;
    @XmlElement(name = "status", required = true)
    private int status;


    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public String getNoAcc() {
        return noAcc;
    }

}
