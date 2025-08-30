package ambiental.sustentavel.services.AcaoServices;

import java.util.List;

import ambiental.sustentavel.dtos.AcaoRequest;
import ambiental.sustentavel.dtos.AcaoResponse;
import ambiental.sustentavel.enums.CategoriaAcao;

public interface AcaoServices{
    public List<AcaoResponse> findAll();
    
    public AcaoResponse findById(Long id);

    public AcaoResponse post(AcaoRequest acaoRequest);

    public AcaoResponse put( Long id, AcaoRequest acaoRequest);

    public void delete(Long id);

    public List<AcaoResponse> findByCategoria(CategoriaAcao categoriaAcao);

}
