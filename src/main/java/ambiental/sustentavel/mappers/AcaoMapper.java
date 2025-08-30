package ambiental.sustentavel.mappers;

import java.util.List;

import ambiental.sustentavel.dtos.AcaoRequest;
import ambiental.sustentavel.dtos.AcaoResponse;
import ambiental.sustentavel.entities.Acao;

public class AcaoMapper {

    private AcaoMapper(){};

    public static Acao toEntity(AcaoRequest acaoRequest){
        Acao acao = new Acao();

        acao.setCategoria(acaoRequest.categoria());
        acao.setTitulo(acaoRequest.titulo());
        acao.setDescricao(acaoRequest.descricao());
        acao.setDataRealizacao(acaoRequest.dataRealizacao());
        acao.setResponsavel(acaoRequest.responsavel());

        return acao;
    }

    public static AcaoResponse toDto(Acao acao){

        return new AcaoResponse(
            acao.getId(),
            acao.getTitulo(),
            acao.getDescricao(),
            acao.getResponsavel(),
            acao.getCategoria(),
            acao.getDataRealizacao()
        );
    }

    public static List<AcaoResponse> responseList(List<Acao> acoes){
        return acoes.stream().map(
            AcaoMapper::toDto
        ).toList();
    }
    
}
