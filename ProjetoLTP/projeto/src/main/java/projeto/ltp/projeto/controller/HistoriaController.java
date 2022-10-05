import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.exemplo_jpa_relacionamento_livros.model.Livro;
import br.edu.ifsp.exemplo_jpa_relacionamento_livros.repository.LivroRepository;

@RestController
public class HistoriaController {
    
    @Autowired
    HistoriaRepository repo;

    @PostMapping("/historia")
    public void adicionaHistoria(
        @RequestBody Historia historia
    ){
        repo.save(historia);
    }

    @GetMapping("/historia")
    public List<Historia> recuperaHistoria(){
        return (List<Historia>)repo.findAll();
    }
}
