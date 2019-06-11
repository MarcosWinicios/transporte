package viewAdministrador;

import java.util.ArrayList;

import model.Instituicao;

public class TelaInstituicao{
	public String opcEdicao = "\n1 - Nome \n2 - Endereco \n3 - Telefone \n4 - Cidade \n5 - Validacao \n0 - Voltar \n\nDigite o numero correspondente: ";
	public String opcConsulta = "\n1 - Nome \n2 - Endereco \n3 - Telefone \n0 - Voltar \n\nDigite o endereco instituicao: ";
	public String cadastro = "\nDigite o valores do instituicao (Ex.: IF Goiano, Meio do mato, 3353-1111, Ceres, Disponivel): ";
	public String entrada = "\nDigite o endereco da instituicao (Ex.: Meio do mato): ";
	public String telaConsulta;

	public void setTelaConsulta(ArrayList<Instituicao> instituicoes){
		if(instituicoes.get(0).getId()){
			this.telaConsulta = "\nInstituicoes: ";
			for (Instituicao i : instituicoes) {
				this.telaConsulta += "\n    Nome: " + i.getNome();
				this.telaConsulta += "\n    Endereco: " + i.getEndereco();
				this.telaConsulta += "\n    Telefone: " + i.getTelefone();
				this.telaConsulta += "\n    Disponibilidade: " + (i.getValidacao() == 1? "Disponivel": "Indisponivel");
				this.telaConsulta += "\n";
			}
			this.telaConsulta += "\nDigite 0 para voltar: ";
		}
		else{
			this.telaConsulta += "\nNao foi encontrada nenhumainstituicao " + new TelaFimOpercao().telaIniAdm;
		}
	}
}