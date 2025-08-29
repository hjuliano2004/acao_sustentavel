package ambiental.sustentavel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ambiental.sustentavel.entities.Acao;
import ambiental.sustentavel.enums.CategoriaAcao;

public interface AcaoRepositorie extends JpaRepository<Acao, Long> {
    

    public List<Acao> findByCategoriaAcao(CategoriaAcao categoriaAcao);
}
