package mz.vm.mpesa.service;


import mz.vm.mpesa.utils.Constants;
import mz.vm.portal.ClientDTO;
import org.springframework.http.HttpEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;


public class ClientServiceCaller extends AbstractModifyAndQueryServiceCaller<ClientDTO, Long> {
    @Override
    public ClientDTO save(ClientDTO info) {
        HttpEntity<ClientDTO> request = new HttpEntity<>(info);
        return client.postForObject(Constants.BASIC_URL + Constants.CLIENT_CREATE, request, ClientDTO.class);
    }

    @Override
    public ClientDTO update(ClientDTO info) {
        try {
            client.put(new URI(Constants.BASIC_URL + Constants.CLIENT_UPDATE), new HttpEntity<>(info));
            info.setUpdatedAt(LocalDateTime.now());
            return info;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        client.delete(Constants.BASIC_URL + Constants.CLIENT_DELETE + "/" + id);
        return true;
    }

    @Override
    public ClientDTO finById(Long id) {
        return client
                .getForEntity(Constants.BASIC_URL + Constants.CLIENT_FIND_BY_ID + "/" + id, ClientDTO.class).getBody();
    }

    /**
     * Find Equipament by its brand
     *
     * @param brand
     * @return
     */
    public List<ClientDTO> finByBrand(String brand) {
        return client
                .getForEntity(Constants.BASIC_URL + Constants.CLIENT_FIND_BY_DOCUMENT_ID + "/" + brand, List.class)
                .getBody();
    }

    /**
     * Find Equipaments by Category Id
     *
     * @param categoryId
     * @return
     */
    public ClientDTO finByCategoryId(Long categoryId) {
        return
                client
                        .getForEntity(Constants.BASIC_URL + Constants.CLIENT_FIND_BY_DOCUMENT_ID + "/" + categoryId, ClientDTO.class)
                        .getBody();
    }

    @Override
    public List<ClientDTO> finAll() {
        return client
                .getForEntity(Constants.BASIC_URL + Constants.CLIENT_ALL, List.class)
                .getBody();
    }
}
