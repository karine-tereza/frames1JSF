package br.com.jsfinicio.repository;

import br.com.jsfinicio.model.CidadeModel;
import br.com.jsfinicio.util.Conexao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kah
 */
public class CidadeRepository extends Conexao{
    
    public void salvar(CidadeModel cidadeModel){
        super.inicializa();
        super.getSess().saveOrUpdate(cidadeModel);
        super.executar();
    }
    public List<CidadeModel> buscarTodos(){
        List<CidadeModel> listaDeCidades = new ArrayList<>();
        super.inicializa();
        listaDeCidades = super.getSess().createQuery("from CidadeModel").list();
        super.executar();
        return listaDeCidades;
    }
    
    public CidadeModel buscarPorID(int cidadeId){
        CidadeModel cidade = new CidadeModel();
        super.inicializa();
        cidade = (CidadeModel) super.getSess().get(CidadeModel.class, cidadeId);
        super.executar();
        return cidade;
    }
}
