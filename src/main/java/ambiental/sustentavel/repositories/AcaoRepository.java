package ambiental.sustentavel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ambiental.sustentavel.entities.Acao;
import ambiental.sustentavel.enums.CategoriaAcao;

@Repository
public interface AcaoRepository extends JpaRepository<Acao, Long> {
    List<Acao> findByCategoria(CategoriaAcao categoria);
}