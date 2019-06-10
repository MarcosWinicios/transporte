package controlUsuario;

import model.*;

import java.util.ArrayList;

import dao.*;

public class ControlUsuario {
	private ArrayList<Rota> rotasIntituicao;
	private ArrayList<Rota> rotasTurno;
	private ArrayList<Rota> rotasFim;
	
	private String turnoSelecionado;
	private Rota rotaSelecionada;
	private Cidade cidadeSelecionada;
	private Instituicao instituicaoSelecionada;
	private Onibus onibusSelecionado;
	private String percursoSelecionado;
	
	private ArrayList<ArrayList<String>> todosIniciosFim;
	private ArrayList<String> todosPercursos;
	/*------------ M�todos para pesquisar cidade e retornar institui��es ------------*/
	
	public Cidade pesquisarCidade(String nome, String uf){
		CidadeDAO cDAO = new CidadeDAO();
		Cidade c = new Cidade();
		c.setNome(nome);
		c.setUf(uf);
		c = cDAO.consultarNomeUf(c, 1);
		this.cidadeSelecionada = c;
	
		return this.cidadeSelecionada;
		
	}
	

	public void selecionarInstituicao(int i) {
		i--;
		this.instituicaoSelecionada = this.cidadeSelecionada.getInstituicoes().get(i);
		buscarRotasBanco();
	}
	/*------------------------------------------------------------------------------------*/
	
	public void buscarRotasBanco() {
		RotaDAO rDAO = new RotaDAO();
		this.rotasIntituicao  = rDAO.consultarIdInsituicao(this.instituicaoSelecionada, 1); 
	}
	
	public void selecionarRota(int i) {
		i--;
		this.rotaSelecionada = this.rotasFim.get(i);
	}
/*----------------------------------------------------------------------------------------------*/
	/*public ArrayList<ArrayList<Horario>> listarTurnosDasRotas() {
		ArrayList<Horario> turnosCadaRota = new ArrayList<Horario>();
		
		for(int i = 0; i < this.rotas.size(); i++) {
			
			for(int j = 0; j < 3; j++) {
				if(this.rotas.get(j) != null) {
					turnosCadaRota.add(this.rotas.get(j).getHorarios().get(j));
				}
			}
			this.turnosTodasRotas.add(turnosCadaRota);
		}
		return this.turnosTodasRotas;
	}*/
	
	/*public  ArrayList<Horario> verificaHorariosIguais(ArrayList<ArrayList<Horario>> turnosTodasRotas) {
		Horario auxHr = new Horario();
		Horario auxHr2 = new Horario();

		ArrayList<Horario> turnos = new ArrayList<Horario>();
		for(int i = 0; i < this.turnosTodasRotas.size(); i++) {
			if(i == 0) {
				auxHr = this.turnosTodasRotas.get(i).get(i);		
				turnos.add(auxHr);
			}
			for(int j = 0; j < 3; j++) {
				auxHr2.setTurno(this.turnosTodasRotas.get(i).get(j).getTurno());
				auxHr2.setHrSaidaPrimeiroPonto(this.turnosTodasRotas.get(i).get(j).getHrSaidaPrimeiroPonto());
				auxHr2.setHrRegresso(this.turnosTodasRotas.get(i).get(j).getHrRegresso());
				
				if(auxHr.getTurno().getTurno() != auxHr2.getTurno().getTurno() || auxHr.getHrSaidaPrimeiroPonto() != auxHr2.getHrSaidaPrimeiroPonto() || auxHr.getHrRegresso() != auxHr2.getHrRegresso()) {
					turnos.add(auxHr);
				}
			}
		}
		return turnos;
	}*/
	
/*----------------------------------------------------------------------------------------------*/
	public boolean filtrarRotasTurno(int turno) {
		
		switch(turno) {
			case 1:
				this.turnoSelecionado = "Matutino";
			case 2:
				this.turnoSelecionado = "Vespertino";
			case 3: 
				this.turnoSelecionado = "Noturno";
		}
		boolean test = false;
		ArrayList<Rota> auxRotas = new ArrayList<Rota>();
		for(int i = 0; i < this.rotasIntituicao.size(); i++) {
			for(int j = 0; j < this.rotasIntituicao.get(i).getHorarios().size(); j++) {
					if(this.rotasIntituicao.get(i).getHorarios().get(j).getTurno().getTurno() == this.turnoSelecionado) {
						auxRotas.add(this.rotasIntituicao.get(i));
						test = true;
						break;
					}	
			}
		}
		if(test) {
			this.rotasTurno = auxRotas;
			return true;
		}else {
			return false;
		}

	}

	/*M�todos para Filtrar rotas por inicio e fim, percurso e ponto*/	
	
	/*public void filtrarRotasTurno(String turno, String ida, String volta) {
		ArrayList<Rota> auxRotas = new ArrayList<Rota>();
		Horario auxHr = new Horario();
		for(int i = 0; i < this.rotas.size(); i++) {
			for(int j = 0; j < 3; j++) {
				auxHr.setHrSaidaPrimeiroPonto(this.rotas.get(i).getHorarios().get(j).getHrSaidaPrimeiroPonto());
				auxHr.setHrRegresso(this.rotas.get(i).getHorarios().get(j).getHrRegresso());
				auxHr.setTurno(this.rotas.get(i).getHorarios().get(j).getTurno());
				if(auxHr.getTurno().getTurno() == turno && auxHr.getHrSaidaPrimeiroPonto() == ida && auxHr.getHrRegresso() == volta) {
					auxRotas.add(this.rotas.get(i));
				}
			}
		}
		this.rotas = new ArrayList<Rota>();
		this.rotas = auxRotas;
	}*/
	
	
	public ArrayList<ArrayList<String>> listarInicioFimDiferentes() {
		ArrayList<ArrayList<String>> todosInicioFim = new  ArrayList<ArrayList<String>>();
		ArrayList<String> auxInicioFim = new ArrayList<String>();
		boolean test = true;
		for(int i = 0; i < this.rotasTurno.size(); i++) {
			auxInicioFim.add(this.rotasTurno.get(i).getInicio());
			auxInicioFim.add(this.rotasTurno.get(i).getFim());			
			if(i == 0) {
				todosInicioFim.add(auxInicioFim);
			}
			for(int j = 0; j < todosInicioFim.size(); j++) {
				if(auxInicioFim.get(0) == todosInicioFim.get(j).get(0) && auxInicioFim.get(1) == todosInicioFim.get(j).get(1)) {
					test = false;
					break;
				}
			}
			if(test) {
				todosInicioFim.add(auxInicioFim);	
			}
		}
		this.todosIniciosFim = todosInicioFim;
		return this.todosIniciosFim;
	}
	
	
	
	public boolean filtrarRotasInicioFim(int x) {
		x--;
		String inicio = this.todosIniciosFim.get(x).get(1);
		String fim = this.todosIniciosFim.get(x).get(2);
		
		ArrayList<Rota> auxRotas = new ArrayList<Rota>();
		boolean test = false;
		for(int i = 0; i < this.rotasTurno.size(); i++) {
			if(this.rotasTurno.get(i).getInicio() == inicio && this.rotasTurno.get(i).getFim() == fim) {
				test = true;
				auxRotas.add(this.rotasTurno.get(i));
			}
		}
		this.rotasFim = new ArrayList<Rota>();
		this.rotasFim = auxRotas;
		if(test) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
	public void selecionarPercurso(int i) {
		i--;
		this.percursoSelecionado = this.todosPercursos.get(i);
		filtrarRotasPercurso();
	}
	
	public void filtrarRotasPercurso() {
		ArrayList<Rota> auxRotas = new ArrayList<Rota>();
		for(int i = 0; i < this.rotasTurno.size(); i++) {
			if(this.rotasTurno.get(i).getPercurso() == percursoSelecionado) {
				auxRotas.add(this.rotasTurno.get(i));
			}
		}
		this.rotasFim = new ArrayList<Rota>();
		this.rotasFim = auxRotas;
	}
	
	public ArrayList<ArrayList<Ponto>> listarPontos() { //- -----------------------------------------------------------------
		ArrayList<ArrayList<Ponto>> pontosTodasRotas = new ArrayList<ArrayList<Ponto>> ();
		ArrayList<Ponto> pontosCadaRota = new ArrayList<Ponto>();
		for(int i = 0; i < this.rotasTurno.size(); i++) {
			for(int j = 0; j < this.rotasTurno.get(i).getPontos().size(); i++) {
				pontosCadaRota.add(this.rotasTurno.get(i).getPontos().get(j));
			}
			pontosTodasRotas.add(pontosCadaRota);
		}
		return pontosTodasRotas;
	}
	
	public void listarPontosDiferentes() {
		for(int i = 0; i < this.rotasTurno.size(); i++) {
			
		}
	}
	public 	ArrayList<String> listarPercursos() {
		ArrayList<String> percursos = new ArrayList<String>();
		String auxPercurso = "";
		boolean test = true;
		for(int i = 0; i < this.rotasTurno.size(); i++) {
			auxPercurso = this.rotasTurno.get(i).getPercurso();
			if(i == 0) {		
				percursos.add(auxPercurso);
			}
			for(int j = 0; j < percursos.size(); j++) {
				if(auxPercurso == percursos.get(j)) {
					test = false;
					break;
				}
			}
			if(test) {
				percursos.add(auxPercurso);
			}
		}
		this.todosPercursos = percursos;
		return this.todosPercursos;
	}
	public void buscarOnibus() {
		OnibusDAO oDAO = new OnibusDAO();
		this.onibusSelecionado = oDAO.consultarIdRota(this.rotaSelecionada, 1); // FALTA CRIAR ESSE M�TODO NO onibusDAO
	}

	/*Getters e Setters*/
	
	public Rota getRotaSelecionada() {
		return rotaSelecionada;
	}

	public void setRotaSelecionada(Rota rotaSelecionada) {
		this.rotaSelecionada = rotaSelecionada;
	}

	public Cidade getCidadeSelecionada() {
		return cidadeSelecionada;
	}

	public void setCidadeSelecionada(Cidade cidadeSelecionada) {
		this.cidadeSelecionada = cidadeSelecionada;
	}

	public Instituicao getInstituicaoSelecionada() {
		return instituicaoSelecionada;
	}

	public void setInstituicaoSelecionada(Instituicao instituicaoSelecionada) {
		this.instituicaoSelecionada = instituicaoSelecionada;
	}

	public Onibus getOnibusSelecionado() {
		return onibusSelecionado;
	}

	public void setOnibusSelecionado(Onibus onibusSelecionado) {
		this.onibusSelecionado = onibusSelecionado;
	}
	
	public String getTurnoSelecionado() {
		return turnoSelecionado;
	}

	public void setTurnoSelecionado(String turnoSelecionado) {
		this.turnoSelecionado = turnoSelecionado;
	}

	
}

