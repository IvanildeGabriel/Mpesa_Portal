package mz.vm.portal.service.impl;

import mz.vm.portal.domain.Client;
import mz.vm.portal.repository.ClientRepository;
import mz.vm.portal.service.AbstractModifiableAndQuerable;
import mz.vm.portal.service.IClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService extends AbstractModifiableAndQuerable<Client, Long> implements IClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<Client> findAllByNameLike(String brand) {
        return repository.findAllByNameLike(brand);
    }

}
