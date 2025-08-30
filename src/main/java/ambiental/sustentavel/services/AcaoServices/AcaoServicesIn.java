package ambiental.sustentavel.services.AcaoServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ambiental.sustentavel.dtos.AcaoRequest;
import ambiental.sustentavel.dtos.AcaoResponse;
import ambiental.sustentavel.entities.Acao;
import ambiental.sustentavel.enums.CategoriaAcao;
import ambiental.sustentavel.exceptions.BadRequestException;
import ambiental.sustentavel.exceptions.RecursoNaoEncontradoException;
import ambiental.sustentavel.mappers.AcaoMapper;
import ambiental.sustentavel.repositories.AcaoRepositorie;

@Service
public class AcaoServicesIn implements AcaoServices{

    @Autowired
    private AcaoRepositorie repository;

    public List<AcaoResponse> findAll(){
        return AcaoMapper.responseList(repository.findAll());
    }

    public AcaoResponse findById(Long id){

        if(!repository.existsById(id)){
            throw new RecursoNaoEncontradoException("ação id: " + id + " não existe!");
        }
        return AcaoMapper.toDto(repository.findById(id).get());
    }

    public AcaoResponse post(AcaoRequest acaoRequest){

        if(acaoRequest == null){
            throw new BadRequestException("não foi possivel cadastrar a ação, todos os parametros precisam ser preenchidos");
        }
            Acao acao = AcaoMapper.toEntity(acaoRequest);
            Acao salvo = repository.save(acao);
            return AcaoMapper.toDto(salvo);
    }

    public AcaoResponse put(Long id, AcaoRequest acaoRequest ){
        return null;
    }

    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new RecursoNaoEncontradoException("ação id: " + id + " não existe");
        }
        repository.deleteById(id);
    }

    public List<AcaoResponse> findByCategoriAcao(CategoriaAcao categoriaAcao){

        if(categoriaAcao == null){
            throw new BadRequestException("a categoria não pode ser nula");
        }
        
        return AcaoMapper.responseList(repository.findByCategoriaAcao(categoriaAcao));
    }
    
}