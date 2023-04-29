package com.project.springbootmongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServerService {

    @Autowired
    private ServerRepository serverRepository;

    public List<Server> getAllServers() {
        return serverRepository.findAll();
    }

    public Optional<Server> getServerById(String id) {
        return serverRepository.findById(id);
    }

    public Server saveServer(Server server) {
        return serverRepository.save(server);
    }

    public void deleteServerById(String id) {
        serverRepository.deleteById(id);
    }

    public List<Server> getServersByName(String name) {
        return serverRepository.findByNameContainingIgnoreCase(name);
    }
}
