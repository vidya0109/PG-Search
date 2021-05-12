package com.example.pgsearch;

public class PgOwner {

    String pgname , pgownername , pgowneremail , aadharno , pgregid;

    public PgOwner(String pgname, String pgownername, String pgowneremail, String aadharno, String pgregid) {
        this.pgname = pgname;
        this.pgownername = pgownername;
        this.pgowneremail = pgowneremail;
        this.aadharno = aadharno;
        this.pgregid = pgregid;
    }

    public String getPgname() {
        return pgname;
    }

    public void setPgname(String pgname) {
        this.pgname = pgname;
    }

    public String getPgownername() {
        return pgownername;
    }

    public void setPgownername(String pgownername) {
        this.pgownername = pgownername;
    }

    public String getPgowneremail() {
        return pgowneremail;
    }

    public void setPgowneremail(String pgowneremail) {
        this.pgowneremail = pgowneremail;
    }

    public String getAadharno() {
        return aadharno;
    }

    public void setAadharno(String aadharno) {
        this.aadharno = aadharno;
    }

    public String getPgregid() {
        return pgregid;
    }

    public void setPgregid(String pgregid) {
        this.pgregid = pgregid;
    }
}
