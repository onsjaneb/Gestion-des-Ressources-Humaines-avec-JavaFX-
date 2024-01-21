package com.example.gestionrh;

import java.io.Serializable;

public class UserData implements Serializable {
    public String nomuser;
    public String  prenomuser;
    public String mailuser;

    public UserData(String nomuser, String prenomuser, String mailuser) {
        this.nomuser = nomuser;
        this.prenomuser = prenomuser;
        this.mailuser = mailuser;
    }

    public String getNomuser() {
        return nomuser;
    }

    public void setNomuser(String nomuser) {
        this.nomuser = nomuser;
    }

    public String getPrenomuser() {
        return prenomuser;
    }

    public void setPrenomuser(String prenomuser) {
        this.prenomuser = prenomuser;
    }

    public String getMailuser() {
        return mailuser;
    }

    public void setMailuser(String mailuser) {
        this.mailuser = mailuser;
    }
}
