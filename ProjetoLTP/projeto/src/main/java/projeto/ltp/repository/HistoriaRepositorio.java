import org.springframework.data.repository.CrudRepository;

import br.edu.ifsp.exemplo_jpa_relacionamento_livros.model.Livro;


public interface HistoriaRepository extends CrudRepository<Historia, Long>{
    
}
