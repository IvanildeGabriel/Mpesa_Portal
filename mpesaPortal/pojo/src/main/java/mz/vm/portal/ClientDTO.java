package mz.vm.portal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;

public class ClientDTO extends AbstractDTO {

    @NotNull
    private String name;
    private String lastname;
    @Past
    private LocalDateTime birthDate;
    @NotNull
    private String cellphone;
    @NotNull
    private String docNumber;
    private DocumentTypeDTO documentTypeDTO;

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

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public DocumentTypeDTO getDocumentTypeDTO() {
        return documentTypeDTO;
    }

    public void setDocumentTypeDTO(DocumentTypeDTO documentTypeDTO) {
        this.documentTypeDTO = documentTypeDTO;
    }
}
