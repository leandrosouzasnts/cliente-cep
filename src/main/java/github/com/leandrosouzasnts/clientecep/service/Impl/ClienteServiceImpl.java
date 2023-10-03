package github.com.leandrosouzasnts.clientecep.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import github.com.leandrosouzasnts.clientecep.model.Cliente;
import github.com.leandrosouzasnts.clientecep.model.Endereco;
import github.com.leandrosouzasnts.clientecep.repository.ClienteRepository;
import github.com.leandrosouzasnts.clientecep.repository.EnderecoRepository;
import github.com.leandrosouzasnts.clientecep.service.ClienteService;
import github.com.leandrosouzasnts.clientecep.service.OpenCepService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired 
    EnderecoRepository enderecoRepository;

    @Autowired
    OpenCepService openCepService;

    @Override
    public Iterable<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public Cliente insert(Cliente cliente) {
        return salvarCliente(cliente);
    }

    @Override
    public void update(Long id, Cliente cliente) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(cliente.getId());
        if (clienteExistente.isPresent()){
            salvarCliente(cliente);
        }
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    private Cliente salvarCliente(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();

        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
           Endereco novoEndereco = openCepService.consultaByOpenCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });

        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
        return cliente;
    }
    
}
