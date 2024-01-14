import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carros")
public class CarroController {

    private final CarroRepository carroRepository;

    public CarroController(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @GetMapping
    public List<Carro> listarCarros() {
        return carroRepository.findAll();
    }

    @PostMapping
    public Carro adicionarCarro(@RequestBody Carro carro) {
        return carroRepository.save(carro);
    }

    @DeleteMapping("/{id}")
    public void removerCarro(@PathVariable Long id) {
        carroRepository.deleteById(id);
    }
}
