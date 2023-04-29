import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servers")
public class ServerController {

    @Autowired
    private ServerRepository serverRepository;

    @GetMapping("")
    public List<Server> getServers(@RequestParam(required = false) String id) {
        if (id == null) {
            return serverRepository.findAll();
        } else {
            Optional<Server> server = serverRepository.findById(id);
            return server.map(Collections::singletonList).orElse(Collections.emptyList());
        }
    }

    @PutMapping("")
    public void createServer(@RequestBody Server server) {
        serverRepository.save(server);
    }

    @DeleteMapping("/{id}")
    public void deleteServer(@PathVariable String id) {
        serverRepository.deleteById(id);
    }
