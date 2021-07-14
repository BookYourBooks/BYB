package com.example.byb.model;

public class printout_document {
    private String description,googledrivelink,numberofcopies,usn;

    public printout_document()
    {

    }

    public printout_document(String description, String googledrivelink, String numberofcopies, String usn) {
        this.description = description;
        this.googledrivelink = googledrivelink;
        this.numberofcopies = numberofcopies;
        this.usn = usn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGoogledrivelink() {
        return googledrivelink;
    }

    public void setGoogledrivelink(String googledrivelink) {
        this.googledrivelink = googledrivelink;
    }

    public String getNumberofcopies() {
        return numberofcopies;
    }

    public void setNumberofcopies(String numberofcopies) {
        this.numberofcopies = numberofcopies;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }
}
