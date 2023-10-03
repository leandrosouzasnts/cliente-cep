package github.com.leandrosouzasnts.clientecep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import github.com.leandrosouzasnts.clientecep.model.Cliente;
import github.com.leandrosouzasnts.clientecep.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> findAll(){
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> insert(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.insert(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente){
        clienteService.update(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        clienteService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
