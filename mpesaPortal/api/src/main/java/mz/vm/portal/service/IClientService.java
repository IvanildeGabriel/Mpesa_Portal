package mz.vm.portal.service;

import mz.vm.portal.domain.Client;

import java.util.List;

public interface IClientService extends ModifiableAndQuerable<Client, Long> {


    /**
     * Find an Client By name
     *
     * @param name
     * @return
     */
    List<Client> findAllByNameLike(String name);

}
