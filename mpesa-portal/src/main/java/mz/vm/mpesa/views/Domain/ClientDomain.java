package mz.vm.mpesa.views.Domain;

import java.util.Date;

public class ClientDomain {
    private String name;
    private String lastname;
    private Date birthDate;
    private String cellphone;
    private DocumentDomain docType;
    private String docNumber;

    public ClientDomain() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public DocumentDomain getDocType() {
        return docType;
    }

    public void setDocType(DocumentDomain docType) {
        this.docType = docType;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }
}
