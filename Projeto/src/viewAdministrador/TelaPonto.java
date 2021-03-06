package viewAdministrador;

import java.util.ArrayList;

import model.Ponto;
import view.TelaFimOperacao;

public class TelaPonto{
	public String opcEdicao = "\nOpcoes: \n\n1 - Endereco \n2 - Validacao \n0 - Voltar \n\nDigite o numero correspondente: ";
	public String cadastro = "\nDigite o valores do ponto (Ex.: Esquina, Disponivel): ";
	public String entrada = "\nDigite o endereco da ponto (Ex.: Esquina): ";
	public String consulta = "\nDigite o valor da consulta: ";
	public String telaConsulta;

	public void setTelaConsulta(ArrayList<Ponto> pontos){
		if(pontos.get(0).getId() != 0){
			this.telaConsulta = "\nPontos: ";
			for (Ponto p : pontos) {
				this.telaConsulta += (p.getOrdem() != 0 ? "\n    Ordem: " + p.getOrdem() : "");
				this.telaConsulta += "\n    Endereco: " + p.getEndereco();
				this.telaConsulta += "\n    Disponibilidade: " + (p.getValidacao() == 1? "Disponivel": "Indisponivel");
				this.telaConsulta += "\n";
			}
			this.telaConsulta += "\nDigite 0 para voltar: ";
		}
		else{
			this.telaConsulta = "\nNao foi encontrado nenhum pontos" + new TelaFimOperacao().telaIniAdm;
		}
	}
}