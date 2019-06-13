package controlAdm;

import model.Onibus;
import model.Rota;

import java.util.ArrayList;

import dao.OnibusDAO;

public class ControlAdmOnibus {
	
	private Onibus onibusSelecionado;
	private ArrayList<Onibus> listaDeOnibus;
	private Rota rotaSelecionada;
	
	public ArrayList<Onibus> consultarCor(String cor){
		OnibusDAO oDAO = new OnibusDAO();
		this.onibusSelecionado = new Onibus();
		this.onibusSelecionado.setCor(cor);
		this.listaDeOnibus =  oDAO.consultarCor(this.onibusSelecionado, 2);
		return this.listaDeOnibus;
	}
	
	public ArrayList<Onibus> consultarMotorista(String motorista){
		OnibusDAO oDAO = new OnibusDAO();
		this.onibusSelecionado = new Onibus();
		this.onibusSelecionado.setMotorista(motorista);
		this.listaDeOnibus =  oDAO.consultarMotorista(this.onibusSelecionado, 2);
		return this.listaDeOnibus;
	}
	
	public Onibus consultarPlaca(String placa){
		OnibusDAO oDAO = new OnibusDAO();
		this.onibusSelecionado = new Onibus();
		this.onibusSelecionado.setPlaca(placa);
		this.onibusSelecionado =  oDAO.consultarPlaca(this.onibusSelecionado, 2).get(0);
		return this.onibusSelecionado;
	}
	
	
	public ArrayList<Onibus> consultarTelefone(String telefone){
		OnibusDAO oDAO = new OnibusDAO();
		this.onibusSelecionado = new Onibus();
		this.onibusSelecionado.setTelefone(telefone);
		this.listaDeOnibus =  oDAO.consultarTelefone(this.onibusSelecionado, 2);
		return this.listaDeOnibus;
	}
	
	public ArrayList<Onibus> consultarMensalidade(double mensalidade){
		OnibusDAO oDAO = new OnibusDAO();
		this.onibusSelecionado = new Onibus();
		this.onibusSelecionado.setMensalidade(mensalidade);
		this.listaDeOnibus =  oDAO.consultarMensalidade(this.onibusSelecionado, 2);
		return this.listaDeOnibus;
	}
	
	public ArrayList<Onibus> listarTodosOnibus(){
		OnibusDAO oDAO = new OnibusDAO();
		this.listaDeOnibus = oDAO.listarOnibus(2);
		return this.listaDeOnibus;
	}
	
	public boolean inserirOnibus(ArrayList<String> valores) {//Placa, cor, motorista, telefone, mensalidade
		OnibusDAO oDAO = new OnibusDAO();

		if(consultarPlaca(valores.get(0)).getId() == 0) {
			this.onibusSelecionado = new Onibus();
			this.onibusSelecionado.setPlaca(valores.get(0));
			this.onibusSelecionado.setCor(valores.get(1));
			this.onibusSelecionado.setMotorista(valores.get(2));
			this.onibusSelecionado.setTelefone(valores.get(3));
			double mensalidade = Double.parseDouble(valores.get(4));
			this.onibusSelecionado.setMensalidade(mensalidade);
			oDAO.inserirOnibus(this.onibusSelecionado);
			if(valores.size() == 5) {
				if(valores.get(4) == "Disponivel") {
					this.onibusSelecionado = consultarPlaca(this.onibusSelecionado.getPlaca());
					this.onibusSelecionado.setValidacao(1);
					oDAO.editarValidacao(this.onibusSelecionado);
						return true;
					}else {
						return false;
					}
				}
			return true;
		}else {
			return false;
		}
	}
	
	public boolean cadastrarRotaOnibus(ArrayList<String> dadosRota) {
		ControlAdmRota ctrlRota = new ControlAdmRota();
		if(ctrlRota.inserirRota(this.onibusSelecionado.getId(), dadosRota)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public boolean editarCor(String cor) {
		OnibusDAO oDAO = new OnibusDAO();

		this.onibusSelecionado.setCor(cor);
		if(oDAO.editarCor(this.onibusSelecionado)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean editarMensalidade(String mensalidade) {
		OnibusDAO oDAO = new OnibusDAO();
  
		double mensalidadeAux = Double.parseDouble(mensalidade);
		this.onibusSelecionado.setMensalidade(mensalidadeAux);
		if(oDAO.editarMensalidade(this.onibusSelecionado)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean editarMotorista(String motorista) {
		OnibusDAO oDAO = new OnibusDAO();
		this.onibusSelecionado.setCor(motorista);
		if(oDAO.editarMotorista(this.onibusSelecionado)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public boolean editarPlaca(String placa) {
		OnibusDAO oDAO = new OnibusDAO();
		this.onibusSelecionado.setPlaca(placa);
		if(oDAO.editarPlaca(this.onibusSelecionado)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean editarTelefone(String telefone) {
		OnibusDAO oDAO = new OnibusDAO();
		this.onibusSelecionado.setTelefone(telefone);
		if(oDAO.editarTelefone(this.onibusSelecionado)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean editarValidacao(String validacao) {
		OnibusDAO oDAO = new OnibusDAO();
		int validade = 0;
		boolean test = false;
		if(validacao == "Disponivel") {
			validade = 1;
		}else {
			validade  = 0;
		}
		if(validade == 1) {
			for(int i = 0; i < this.onibusSelecionado.getRotas().size(); i++) {
				if(this.onibusSelecionado.getRotas().get(i).getValidacao() == 1) {
					test = true;
					break;
				}
			}
			if(test) {
				this.onibusSelecionado.setValidacao(validade);
				if(oDAO.editarValidacao(this.onibusSelecionado)) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}else {
			this.onibusSelecionado.setValidacao(validade);
			if(oDAO.editarValidacao(this.onibusSelecionado)) {
				return true;
			}else {
				return false;
			}
		}
		
	}
	
	public boolean removerRota(String identidicador) { // Antes de usar esse m�todo, vc precisa utilizar o listar Rotas pra copiar o identificador dela e passar aqui como parametro
														//O ADM QUE VAI FAZER ISSO
		int aux = 0;
		boolean test = false;
		int identificador = Integer.parseInt(identidicador);
		
		for(int i = 0; i < this.onibusSelecionado.getRotas().size(); i++) {
			if(this.onibusSelecionado.getRotas().get(i).getIdentificador() == identificador) {
				aux = i;
				test = true;
				break;
			}
		}
		if(test) {
			this.rotaSelecionada = this.onibusSelecionado.getRotas().get(aux);
			ControlAdmRota ctrlRota = new ControlAdmRota();
			ctrlRota.setRotaSelecionada(this.rotaSelecionada);
			if(ctrlRota.excluirRota()) {
				return true;
			}else
				return false;
		}else {
			return false;
		}
	}
	
	public Onibus getOnibusSelecionado() {
		return onibusSelecionado;
	}

	public void setOnibusSelecionado(Onibus onibusSelecionado) {
		this.onibusSelecionado = onibusSelecionado;
	}

	public ArrayList<Onibus> getListaDeOnibus() {
		return listaDeOnibus;
	}

	public void setListaDeOnibus(ArrayList<Onibus> listaDeOnibus) {
		this.listaDeOnibus = listaDeOnibus;
	}

	public Rota getRotaSelecionada() {
		return rotaSelecionada;
	}

	public void setRotaSelecionada(Rota rotaSelecionada) {
		this.rotaSelecionada = rotaSelecionada;
	}

	public ArrayList<Rota> listarRotas(){
		return this.onibusSelecionado.getRotas();
	}
	
}
