package github.com.leandrosouzasnts.clientecep.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import github.com.leandrosouzasnts.clientecep.model.Endereco;

@FeignClient(name = "opencep", url = "https://opencep.com/v1")
public interface OpenCepService {
    
    @RequestMapping(method = RequestMethod.GET, value = "/{cep}")
    Endereco consultaByOpenCep(@PathVariable("cep") String cep);
}

