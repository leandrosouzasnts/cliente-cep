package github.com.leandrosouzasnts.clientecep.service;

import github.com.leandrosouzasnts.clientecep.model.Cliente;


public interface ClienteService {

    Iterable<Cliente> findAll();
    Cliente findById(Long id);
    Cliente insert (Cliente cliente);
    void update(Long id, Cliente cliente);
    void deleteById(Long id);
}
