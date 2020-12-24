package mz.vm.mpesa.service;


import mz.vm.mpesa.utils.Constants;
import mz.vm.portal.DocumentTypeDTO;
import org.springframework.http.HttpEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


public class DocumentServiceCaller extends AbstractModifyAndQueryServiceCaller<DocumentTypeDTO, Long> {
    @Override
    public DocumentTypeDTO save(DocumentTypeDTO info) {
        HttpEntity<DocumentTypeDTO> request = new HttpEntity<>(info);
        return client.postForObject(Constants.BASIC_URL + Constants.DOCUMENT_CREATE, request, DocumentTypeDTO.class);
    }

    @Override
    public DocumentTypeDTO update(DocumentTypeDTO info) {
        try {
            client.put(new URI(Constants.BASIC_URL + Constants.DOCUMENT_UPDATE), new HttpEntity<>(info));
            info.setUpdatedAt(LocalDateTime.now());
            return info;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        client.delete(Constants.BASIC_URL + Constants.DOCUMENT_DELETE + "/" + id);
        return true;
    }

    @Override
    public DocumentTypeDTO finById(Long id) {
        return client
                .getForEntity(Constants.BASIC_URL + Constants.DOCUMENT_FIND_BY_ID + "/" + id, DocumentTypeDTO.class).getBody();
    }

    /**
     * Find Document by Name
     *
     * @param name
     * @return
     */
    public DocumentTypeDTO finByName(String name) {
        return client
                .getForEntity(Constants.BASIC_URL + Constants.DOCUMENT_FIND_BY_NAME + "/" + name, DocumentTypeDTO.class)
                .getBody();
    }

    @Override
    public List<DocumentTypeDTO> finAll() {
        DocumentTypeDTO[] response = client.getForEntity(Constants.BASIC_URL + Constants.DOCUMENT_ALL, DocumentTypeDTO[].class).getBody();
        return Arrays.asList(response);
    }
}
