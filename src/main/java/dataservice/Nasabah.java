package dataservice;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "##default", propOrder = {
        "status",
        "nasabahId",
        "name",
        "password",
        "noRek",
        "saldo"
})

@XmlRootElement(name = "")
public class Nasabah {
    @XmlElement(name = "nasabahId", required = true)
    private int nasabahId;
    @XmlElement(name = "name", required = true)
    private String name;
    @XmlElement(name = "password", required = true)
    private String password;
    @XmlElement(name = "noRek", required = true)
    private String noRek;
    @XmlElement(name = "saldo", required = true)
    private int saldo;
    @XmlElement(name = "status", required = true)
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNasabahId() {
        return nasabahId;
    }

    public void setNasabahId(int nasabahId) {
        this.nasabahId = nasabahId;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setNoRek(String noRek) {
        this.noRek = noRek;
    }

    public String getNoRek() {
        return noRek;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

}
