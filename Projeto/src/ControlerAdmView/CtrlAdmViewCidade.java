package controlerAdmView;

public class CtrlAdmViewCidade{
	public String acesso2;
	public String acesso3;
	public String acesso4;
	public String acesso5;

	public String entrada(){
		switch(this.acesso2){
			//Tela de fim de operacao ou argumento invalido
			case -1:
				switch(arg) {
					case 0:
						this.acesso2 = 0;
						this.acesso1 = 0;
						this.exit = true;
						this.tela = new TelaInicial().telaIni;
						break;
					case 1:
						this.acesso2 = 0;
						this.tela = new TelaManter().telaIni;
						break;
					default:
						this.tela = new TelaArgInvalido().telaIni;
						this.acesso2 = -1;
						break;
				}
				break;
			case 0:
				switch(arg){
					//Retorna para tela inicial de Manter Cidade
					case 0:
						this.acesso2 = 0;
						this.tela = new TelaManter().telaIni;
						break;
					//Vai para tela de selecionar dados para consulta
					case 1:
						this.tela = new TelaCidade().opcConsulta;
						this.acesso2 = 1;
						break;
					//Vai para tela de entrada de dados para cadastro
					case 2:
						this.tela = new TelaCidade().cadastro;
						this.acesso2 = 2;
						break;
					//Vai para tela de selecionar dados para edicao
					case 3:
						this.tela = new TelaCidade().opcEdicao;
						this.acesso2 = 3;
						break;
					//Vai para tela de entrada de dados para exclusao
					case 4:
						this.tela = new TelaCidade().entrada;
						this.acesso2 = 4;
						break;
					//Vai para tela de Listagem
					case 5:
						ArrayList<Cidade> consulta = listarCidades();//Metodo que lista cidade --M.W. deve setar
						TelaCidade tela = new TelaCidade();
						tela.setTelaConsulta(consulta);
						this.tela = tela.telaConsulta;
						break;
					default:
						this.tela = new TelaArgInvalido().telaIni;
						this.acesso2 = -1;
						break;
				}
				break;
			//Vai para tela de consulta da opcao selecionada
			case 1:
				switch(this.acesso3){
					case -1:
						switch(arg) {
							case 0:
								this.acesso3 = 0;
								this.acesso2 = 0;
								this.acesso1 = 0;
								this.exit = true;
								this.tela = new TelaInicial().telaIni;
								break;
							case 1:
								this.acesso3 = 0;
								this.acesso2 = 0;
								this.tela = new TelaManter().telaIni;
								break;
							default:
								this.tela = new TelaArgInvalido().telaIni;
								this.acesso3 = -1;
								break;
						}
						break;
					case 0:
						switch(arg){
							//Consulta por nome
							case 1:
								ArrayList<Cidade> consulta = lista(entrada);//Metodo que lista cidade por nome --M.W. deve setar, entrada corespone a string usada de parametro
								TelaCidade tela = new TelaCidade();
								tela.setTelaConsulta(consulta);
								this.tela = tela.telaConsulta;
								break;
							//Consulta por uf
							case 2:
								ArrayList<Cidade> consulta = lista(entrada);//Metodo que lista cidade por uf --M.W. deve setar, entrada corespone a string usada de parametro
								TelaCidade tela = new TelaCidade();
								tela.setTelaConsulta(consulta);
								this.tela = tela.telaConsulta;
								break;
							//Consulta por instituicao
							case 3:
								ArrayList<Cidade> consulta = lista(entrada);//Metodo que lista cidade por instituicao --M.W. deve setar, entrada corespone a string usada de parametro
								TelaCidade tela = new TelaCidade();
								tela.setTelaConsulta(consulta);
								this.tela = tela.telaConsulta;
								break;
							default:
								this.tela = new TelaArgInvalido().telaIni;
								this.acesso3 = -1;
								break;
						}
						break;
				}
				break;
			//Vai para tela entrada de dados a serem inseridos
			case 2:
				switch(this.acesso3){
					case -1:
						switch(arg) {
							case 0:
								this.acesso3 = 0;
								this.acesso2 = 0;
								this.acesso1 = 0;
								this.exit = true;
								this.tela = new TelaInicial().telaIni;
								break;
							case 1:
								this.acesso3 = 0;
								this.tela = new TelaCidade().cadastro;
								break;
							default:
								this.tela = new TelaArgInvalido().telaIni;
								this.acesso3 = -1;
								break;
						}
						break;
					case 0:
						switch(arg){
							//Cadastrar cidade
							case 1:
								String regex = "(( , )|( ,)|(, )|(,))";
								ArrayList<String> entradas = new ArrayList<String>(Arrays.asList(entrada.split(regex)));
								if(inseriCidadeSelecionada(entradas.get(0), entradas.get(1), entradas.get(3))){//Metodo insere dados na tabela Cidade --M.W. deve setar, entrada corespone a string usada de parametro
									this.tela = new TelaFimOperacao().sucesso + new TelaFimOperacao().telaIni;
								}
								else{
									this.tela = new TelaFimOperacao().sucesso + new TelaFimOperacao().erro;
								}
							default:
								this.tela = new TelaArgInvalido().telaIni;
								this.acesso3 = -1;
								break;
						}
						break;
				}
			//Vai para tela opcoes de edicao
			case 3:
				switch(this.acesso3){
					case -1:
						switch(arg) {
							case 0:
								this.acesso3 = 0;
								this.acesso2 = 0;
								this.acesso1 = 0;
								this.exit = true;
								this.tela = new TelaInicial().telaIni;
								break;
							case 1:
								this.acesso3 = 0;
								this.tela = new TelaCidade().opcEdicao;
								break;
							default:
								this.tela = new TelaArgInvalido().telaIni;
								this.acesso3 = -1;
								break;
						}
						break;
					case 0:
						switch(arg){
							//Editrar nome cidade
							case 1:
								this.acesso3 = 1;
								this.tela = new TelaCidade().entrada;
								break;
							case 2:
								this.acesso3 = 2;
								this.tela = new TelaCidade().entrada;
								break;
							case 3:
								this.acesso3 = 3;
								this.tela = new TelaCidade().entrada;
								break;
							case 4:
								this.acesso3 = 4;
								this.tela = new TelaCidade().entrada;
								break;
							default:
								this.tela = new TelaArgInvalido().telaIni;
								this.acesso3 = -1;
								break;
						}
						break;
					case 1:
						switch(this.acesso4){
							case -1:
								switch(arg) {
									case 0:
										this.acesso4 = 0;
										this.acesso3 = 0;
										this.acesso2 = 0;
										this.acesso1 = 0;
										this.exit = true;
										this.tela = new TelaInicial().telaIni;
										break;
									case 1:
										this.acesso4 = 0;
										this.tela = new TelaManter().telaEdicao;
										break;
									default:
										this.tela = new TelaArgInvalido().telaIni;
										this.acesso4 = -1;
										break;
								}
								break;
							case 0:
								String regex = "(( , )|( ,)|(, )|(,))";
								ArrayList<String> entradas = new ArrayList<String>(Arrays.asList(entrada.split(regex)));
								selecionarCidade(entradas.get(0), entradas.get(1));//Metodo seleciona cidade no controlador --M.W. deve setar, entrada corespone a string usada de parametro
								this.tela = new TelaManter().telaEdicao;
								this.acesso4 = 1;
								break;
							case 1:
								editrarNomeCidadeSelecionada(entrada); //Metodo edita nome da Cidade selecionada no controlador --M.W. deve setar, entrada corespone a string usada de parametro
								this.tela = new TelaFimOperacao().telaIni;
								acesso4 = 2;
								break;
							case 2:
								if(arg == 0){
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.acesso2 = 0;
									this.acesso1 = 0;
									this.exit = true;
									this.tela = new TelaInicial().telaIni;
								}
								else if(arg == 1){
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.tela = new TelaManter().telaEdicao;
								}
								break;
							default:
								this.tela =  new TelaArgInvalido().telaIni;
								this.acesso4 = -1;
								break;
						}
						
						break;
					case 2:
						switch(this.acesso4){
							case -1:
								switch(arg) {
									case 0:
										this.acesso4 = 0;
										this.acesso3 = 0;
										this.acesso2 = 0;
										this.acesso1 = 0;
										this.exit = true;
										this.tela = new TelaInicial().telaIni;
										break;
									case 1:
										this.acesso4 = 0;
										this.tela = new TelaManter().telaEdicao;
										break;
									default:
										this.tela = new TelaArgInvalido().telaIni;
										this.acesso4 = -1;
										break;
								}
								break;
							case 0:
								SString regex = "(( , )|( ,)|(, )|(,))";
								ArrayList<String> entradas = new ArrayList<String>(Arrays.asList(entrada.split(regex)));
								selecionarCidade(entradas.get(0), entradas.get(1));//Metodo seleciona cidade no controlador --M.W. deve setar, entrada corespone a string usada de parametro
								this.tela = new TelaManter().telaEdicao;
								this.acesso4 = 1;
								break;
							case 1:
								editrarUfCidadeSelecionad(entrada); //Metodo edita nome da Cidade selecionada no controlador --M.W. deve setar, entrada corespone a string usada de parametro
								this.tela = new TelaFimOperacao().telaIni;
								this.acesso4 = 2;
								break;
							case 2:
								if(arg == 0){
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.acesso2 = 0;
									this.acesso1 = 0;
									this.exit = true;
									this.tela = new TelaInicial().telaIni;
								}
								else if(arg == 1){
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.tela = new TelaManter().telaEdicao;
								}
								break;
							default:
								this.tela =  new TelaArgInvalido().telaIni;
								this.acesso4 = -1;
								break;
						}
						break;
					case 3:
						switch(this.acesso4){
							case -1:
								switch(arg) {
									case 0:
										this.acesso4 = 0;
										this.acesso3 = 0;
										this.acesso2 = 0;
										this.acesso1 = 0;
										this.exit = true;
										this.tela = new TelaInicial().telaIni;
										break;
									case 1:
										this.acesso4 = 0;
										this.tela = new TelaManter().telaEdicao;
										break;
									default:
										this.tela = new TelaArgInvalido().telaIni;
										this.acesso4 = -1;
										break;
								}
								break;
							case 0:
								String regex = "(( , )|( ,)|(, )|(,))";
								ArrayList<String> entradas = new ArrayList<String>(Arrays.asList(entrada.split(regex)));
								selecionarCidade(entradas.get(0), entradas.get(1));//Metodo seleciona cidade no controlador --M.W. deve setar, entrada corespone a string usada de parametro
								this.tela = new TelaManter().telaEdicao;
								this.acesso4 = 1;
								break;
							case 1:
								this.tela = new TelaInstituicao().opcCidade;
								this.acesso4 = 2;
								break;
							case 2:
								switch(this.acesso5){
									case -1:
										switch(arg) {
											case 0:
												this.acesso4 = 0;
												this.acesso3 = 0;
												this.acesso2 = 0;
												this.acesso1 = 0;
												this.exit = true;
												this.tela = new TelaInicial().telaIni;
												break;
											case 1:
												this.acesso5 = 0;
												this.tela = new TelaInstituicao().opcCidade;
												break;
											default:
												this.tela = new TelaArgInvalido().telaIni;
												this.acesso4 = -1;
												break;
										}
										break;
									case 0:
										switch(arg){
											case 0:
												this.tela = new TelaCidade().opcEdicao;
												this.acesso3 = 0;
												break;
											case 1:
												this.tela = new TelaInstituicao().entrada;
												this.acesso5 = 1;
												break;
											case 2:
												this.tela = new TelaInstituicao().entrada;
												this.acesso5 = 2;
											default:
												this.tela = new TelaArgInvalido().telaIni;
												this.acesso4 = -1;
												break;
										}
										break;
									case 1:
										controler.getCidadeSelecionada().getInstituicoes().add(controler.consultaEnderecoInstituicao(entrada));
										break;
									case 2:
										controler.removeInstituicaoCidade(controler.consultaEnderecoInstituicao(entrada));
										break;
								}
							case 3:
								TelaInstituicao tela = new TelaInstituicao();
								tela.setTelaConsulta(controler.getCidadeSelecionada().getInstituicoes()); //Metodo edita instituicao da Cidade selecionada no controlador --M.W. deve setar, entrada corespone a string usada de parametro
								this.tela = tela.telaConsulta;
								this.acesso4 = 4;
								break;
							case 4:
								if(arg == 0){
									this.acesso5 = 0;
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.acesso2 = 0;
									this.acesso1 = 0;
									this.exit = true;
									this.tela = new TelaInicial().telaIni;
								}
								else if(arg == 1){
									this.acesso5 = 0;
									this.tela = new TelaInstituicao().opcCidade;
								}
								break;
							default:
								this.tela =  new TelaArgInvalido().telaIni;
								this.acesso4 = -1;
								break;
						}
						break;
					case 4:
						switch(this.acesso4){
							case -1:
								switch(arg) {
									case 0:
										this.acesso4 = 0;
										this.acesso3 = 0;
										this.acesso2 = 0;
										this.acesso1 = 0;
										this.exit = true;
										this.tela = new TelaInicial().telaIni;
										break;
									case 1:
										this.acesso4 = 0;
										this.tela = new TelaManter().telaEdicao;
										break;
									default:
										this.tela = new TelaArgInvalido().telaIni;
										this.acesso4 = -1;
										break;
								}
								break;
							case 0:
								String regex = "(( , )|( ,)|(, )|(,))";
								ArrayList<String> entradas = new ArrayList<String>(Arrays.asList(entrada.split(regex)));
								selecionarCidade(entradas.get(0), entradas.get(1));//Metodo seleciona cidade no controlador --M.W. deve setar, entrada corespone a string usada de parametro
								this.tela = new TelaManter().telaEdicao;
								this.acesso4 = 1
								break;
							case 1:
								editrarValidacaoCidade(entrada); //Metodo edita validacao da Cidade selecionada no controlador --M.W. deve setar, entrada corespone a string usada de parametro
								this.tela = new TelaFimOperacao().telaIni;
								acesso4 = 2;
								break;
							case 2:
								if(arg == 0){
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.acesso2 = 0;
									this.acesso1 = 0;
									this.exit = true;
									this.tela = new TelaInicial().telaIni;
								}
								else if(arg == 1){
									this.acesso4 = 0;
									this.acesso3 = 0;
									this.tela =  new TelaManter().telaEdicao;
								}
								break;
							default:
								this.tela =  new TelaArgInvalido().telaIni;
								this.acesso4 = -1;
								break;
						}
						break;
					default:

						break;
				}
		}
		break;
	}
}