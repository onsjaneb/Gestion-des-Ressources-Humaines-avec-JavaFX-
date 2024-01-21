package com.example.gestionrh;

import java.io.Serializable;

public class MdpData implements Serializable {
    String mdp;
    String mdpcnf;

    public MdpData(String mdp, String mdpcnf) {
        this.mdp = mdp;
        this.mdpcnf = mdpcnf;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getMdpcnf() {
        return mdpcnf;
    }

    public void setMdpcnf(String mdpcnf) {
        this.mdpcnf = mdpcnf;
    }
}
