package mz.vm.portal.controller;

import mz.vm.portal.ClientDTO;
import mz.vm.portal.domain.Client;
import mz.vm.portal.service.impl.ClientService;
import mz.vm.portal.util.InfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("client")
public class ClientController extends AbstractModifiableAndQuerableController<Client, Long, ClientDTO> {
    private final ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        super(service, Client.class, ClientDTO.class);
        this.service = service;
    }

    @GetMapping("find-by-name/{name}")
    public ResponseEntity<List<ClientDTO>> findAllByName(@PathVariable String name) {
        return ResponseEntity.ok().body(service.findAllByNameLike(name).stream().map(client -> InfoUtils.toInfo(client, ClientDTO.class)).collect(Collectors.toList()));
    }

}
