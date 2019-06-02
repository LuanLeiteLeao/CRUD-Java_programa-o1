package interfaces;

import javax.swing.JFrame;

public class Jframe extends JFrame{

	public Jframe(){
		
		setTitle("Calculadora");
		setSize(367,631);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(new Jpanel());
		setVisible(true);
		
		
		
	}
	
}
