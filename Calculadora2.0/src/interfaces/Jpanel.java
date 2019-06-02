package interfaces;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sql.rowset.spi.TransactionalWriter;
import javax.swing.*;

public class Jpanel extends JPanel{
	private JTextField        escreverNaTela1;
	private JTextField        escreverNaTela2;
	private JPanel            ariaParaEscrever;
	private JPanel            ariaParaBotoesNumericos;
	private JPanel            ariaParaBotoesOperacionais;
	private JButton[]         botoesNumericos;
	private JButton[]         botoesOperacionais;
	private char[]            charDosOperadores; 
	private static char       Apagar = '⟵';   
	private static final int  ALTURA  = 5;
	private static final int  LARGURA = 5;
	private Eventos trataEventos;
	
	
	public Jpanel () {
		
		escreverNaTela1       = new JTextField();
		escreverNaTela2       = new JTextField();
		ariaParaEscrever      = new JPanel();
		ariaParaBotoesNumericos        = new JPanel();
		ariaParaBotoesOperacionais = new JPanel();
		botoesNumericos       = new JButton[10];
		botoesOperacionais    = new JButton[7];
		charDosOperadores     = new char []{'/','*','-','+','.','='};
		
		trataEventos = new Eventos();
		
		
		
		
		inicializarBotoesNumericos();
		
		inicializarBotoesOperacionais();
		
		PossicoesLayout();
		
		botoesEstruturaDeApresentacao();
		
		

		
	}




	private void botoesEstruturaDeApresentacao() {
		escreverNaTela1.setEditable(false);
		escreverNaTela2.setEditable(false);
		
		escreverNaTela1.setFont(new java.awt.Font("DS", 1, 64));
		escreverNaTela2.setFont(new java.awt.Font("DS", 1, 64));
	
		ariaParaEscrever.add(escreverNaTela1);
		ariaParaEscrever.add(escreverNaTela2);
		ariaParaEscrever.add(botoesOperacionais[6]);
		
		
		ariaParaBotoesNumericos.add(botoesNumericos[7]);
		ariaParaBotoesNumericos.add(botoesNumericos[8]);
		ariaParaBotoesNumericos.add(botoesNumericos[9]);
		ariaParaBotoesOperacionais.add(botoesOperacionais[0]);
		
		ariaParaBotoesNumericos.add(botoesNumericos[4]);
		ariaParaBotoesNumericos.add(botoesNumericos[5]);
		ariaParaBotoesNumericos.add(botoesNumericos[6]);
		ariaParaBotoesOperacionais.add(botoesOperacionais[1]);
		
		ariaParaBotoesNumericos.add(botoesNumericos[1]);
		ariaParaBotoesNumericos.add(botoesNumericos[2]);
		ariaParaBotoesNumericos.add(botoesNumericos[3]);
		ariaParaBotoesOperacionais.add(botoesOperacionais[2]);
		

		ariaParaBotoesNumericos.add(botoesOperacionais[4]);
		ariaParaBotoesNumericos.add(botoesNumericos[0]);
		ariaParaBotoesNumericos.add(botoesOperacionais[5]);
		ariaParaBotoesOperacionais.add(botoesOperacionais[3]);
	}




	private void inicializarBotoesOperacionais() {
		for(int i=0;i<botoesOperacionais.length-1;i++) {
			botoesOperacionais[i] = new JButton(Character.toString(charDosOperadores[i]));
			botoesOperacionais[i].setSize(ALTURA,LARGURA);
			
			botoesOperacionais[i].addActionListener(trataEventos);
		}
		
	
		botoesOperacionais[6] = new JButton(Character.toString(Apagar) );
		botoesOperacionais[6].setSize(ALTURA,LARGURA);
		botoesOperacionais[6].addActionListener(trataEventos);
	}




	private void inicializarBotoesNumericos() {
		for(int i=0; i< botoesNumericos.length;i++) {
			
			botoesNumericos[i] = new JButton(Integer.toString(i));
			botoesNumericos[i].setSize(ALTURA,LARGURA);
			
			botoesNumericos[i].addActionListener(trataEventos);
			
		}
	}


	
	
	private void PossicoesLayout() {
		
		setLayout(new BorderLayout()); // meu layout princiapal
		ariaParaEscrever.setLayout(new GridLayout(3,0));
		ariaParaBotoesNumericos.setLayout(new GridLayout(4,4));
		ariaParaBotoesOperacionais.setLayout(new GridLayout(4,0));;
		
		add("North",ariaParaEscrever);
		add("Center",ariaParaBotoesNumericos);
		add("East",ariaParaBotoesOperacionais);
		
	}

	
	
	public class  Eventos implements ActionListener {
		private  int     cont;
		private  char    operador;
		private  double  resultado;
		private  double  numero1;
		private  double  numero2;
		private  boolean ponto=true;
		private  boolean num=false;
		private  boolean ope=true;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			for(cont=0;cont<botoesNumericos.length;cont++) {
				
				
				if(e.getSource() == botoesNumericos[cont]) {
					num=true;
					
					
					if(!ope) {
						ponto=true;
						escreverNaTela2.setText(" ");
					}
					
					
					escreveNaTela(escreverNaTela2,Integer.toString(cont));
					
					
				}
			
				
				
				if(cont <4 && e.getSource() == botoesOperacionais[cont] && num==true&&ope==true) {
														
					
					numero1 = pegaNumeros(escreverNaTela2);
					operador = charDosOperadores[cont];
					
					escreveNaTela(escreverNaTela1, escreverNaTela2.getText()+Character.toString(operador));
				    
					escreverNaTela2.setText("");
					
					ope=false;
					
					
				}
							
				
				
				
				
					
				}
			
			
			
			if(e.getSource() == botoesOperacionais[4] && num==true &&ponto==true) {
				escreveNaTela(escreverNaTela2, Character.toString(charDosOperadores[4]));
				ponto=false;
			}
			
			
			
			if(e.getSource() == botoesOperacionais[6]) {
				
				String string = escreverNaTela2.getText(); 
				
				

					string = string.substring(0, string.length()-1);
					
					escreverNaTela2.setText(string);
				
				
				
			
			}
			
			
			if(e.getSource() == botoesOperacionais[5]) {
				
				numero2 = pegaNumeros(escreverNaTela2);
				

				
					
				
				
				switch (operador) {
				case '+':
					numero1+=numero2;
					break;
				
				case '-':
					numero1-=numero2;
					break;

				case '*':
					numero1*=numero2;
					break;

				case '/':
					if(numero1==0 || numero2==0) {
						numero1 = 0;
					}else {
						numero1/=numero2;
						
					}
					break;
	
				}
				
				
				atualizarTela();
				
				reiniciaACalculadora();
				
			}
			
			
			
			
		}




		private void atualizarTela() {
			
			escreverNaTela2.setText("");
			escreverNaTela1.setText("");
			
			
			escreveNaTela(escreverNaTela2,  Double.toString(numero1));
		}




		private void reiniciaACalculadora() {
			ponto=true;
			num=true;
			ope=true;
		}




		private double pegaNumeros(JTextField escreverNaTela) {
			
			return Double.parseDouble(escreverNaTela.getText() );
			
		}
		
		
		
		
		private void escreveNaTela(JTextField escreverNaTela, String escrever) {
			escreverNaTela.setEditable(true);
			
	
			escreverNaTela.setText(escreverNaTela.getText() + escrever);;
			escreverNaTela.setEditable(false);
		}
		
		
	
	}

	
	
}
