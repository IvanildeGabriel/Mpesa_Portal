package mz.vm.mpesa.service;


import mz.vm.portal.ClientDTO;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;

public abstract class AbstractServiceCaller implements Serializable {
    protected final RestTemplate client = new RestTemplate();;
}
