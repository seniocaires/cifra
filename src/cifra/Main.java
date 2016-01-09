/*
 * Cifra, ferramenta para cifrar textos.
 * Copyright (c) 2015 Sênio Caires
 * e-mail: seniocaires@gmail.com
 * 
 * Este arquivo é parte do programa Cifra
 * 
 * Cifra é um software livre; você pode redistribuí-lo e/ou
 * modificá-lo dentro dos termos da Licença Pública Geral GNU como
 * publicada pela Fundação do Software Livre (FSF); na versão 3 da
 * Licença, ou (na sua opinião) qualquer versão.
 * 
 * Este programa é distribuído na esperança de que possa ser  útil,
 * mas SEM NENHUMA GARANTIA; sem uma garantia implícita de ADEQUAÇÃO
 * a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a
 * Licença Pública Geral GNU para maiores detalhes.
 * 
 * Você deve ter recebido uma cópia da Licença Pública Geral GNU junto
 * com este programa, Se não, veja <http://www.gnu.org/licenses/>.
 */
package cifra;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Data da primeira versão 04/07/2011.
 * @author Senio Caires
 * @version 0.11.7.4
 * @since 0.11.7.1
 */
public class Main extends JFrame {

	/**
	 * serialVersionUID.
	 * @author Senio Caires
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Resultado da cifra.
	 * @author Senio Caires
	 */
	private transient final JTextArea resultado;

	/**
	 * Texto digitado pelo usuário.
	 * @author Senio Caires
	 */
	private transient final JTextArea texto;

	/**
	 * Hash com as chaves.
	 * @author Senio Caires
	 */
	private static Map<Character,Character> hash;

	static {

		hash = new HashMap<Character, Character>();

		// Adicione mais pares de caracteres para aumentar a complexidade da cifra.

		hash.put('a', 'p');
		hash.put('p', 'a');
		hash.put('A', 'P');
		hash.put('P', 'A');

		hash.put('e', 'z');
		hash.put('z', 'e');
		hash.put('E', 'Z');
		hash.put('Z', 'E');

		hash.put('i', 'r');
		hash.put('r', 'i');
		hash.put('I', 'R');
		hash.put('R', 'I');

		hash.put('o', 'f');
		hash.put('f', 'o');
		hash.put('O', 'F');
		hash.put('F', 'O');

		hash.put('u', 'c');
		hash.put('c', 'u');
		hash.put('U', 'C');
		hash.put('C', 'U');

		hash.put('d', 'g');
		hash.put('g', 'd');
		hash.put('D', 'G');
		hash.put('G', 'D');
	}

	/**
	 * Construtor e inicializador.
	 * @author Senio Caires
	 */
	public Main() {

		super("Cifra");

		final Container tela = obterContainer();

		final BorderLayout layout = new BorderLayout();
		tela.setLayout(layout);

		final Tratador tratador = new Tratador(this);
		final TratadorLimpar tratadorLimpar = new TratadorLimpar(this);

		final JButton botaoConverter = new JButton("Converter");
		final JButton botaoLimpar = new JButton("Limpar");
		botaoConverter.addActionListener(tratador);
		botaoLimpar.addActionListener(tratadorLimpar);

		this.resultado = new JTextArea(10, 20);
		this.texto = new JTextArea(10, 20);
		this.texto.setText("Digite o texto aqui.");

		this.resultado.setEditable(false);

		final JScrollPane painelRolagemTexto = new JScrollPane(this.resultado);
		painelRolagemTexto.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		painelRolagemTexto.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		final JScrollPane painelRolagemResultado = new JScrollPane(texto);
		painelRolagemResultado.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		painelRolagemResultado.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		final JPanel pSuperior = new JPanel();
		pSuperior.setLayout(new FlowLayout(FlowLayout.TRAILING));
		pSuperior.add(painelRolagemResultado);

		final JPanel pCentro = new JPanel();
		pCentro.setLayout(new FlowLayout(FlowLayout.TRAILING));
		pCentro.add(painelRolagemTexto);

		final JPanel pInferiorBotao = new JPanel();
		pInferiorBotao.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pInferiorBotao.add(botaoLimpar);
		pInferiorBotao.add(botaoConverter);

		tela.add(BorderLayout.NORTH, pSuperior);
		tela.add(BorderLayout.CENTER, pCentro);
		tela.add(BorderLayout.SOUTH, pInferiorBotao);

		this.alterarConfiguracoes(false, true);

		this.empacotar();
	}

	/**
	 * Altera as configurações da janela.
	 * @author Senio Caires
	 * @param redimensionavel - Define se a janela será redimensionável
	 * @param visivel - Define se a janela será visível
	 */
	private void alterarConfiguracoes(boolean redimensionavel, boolean visivel) {
		setResizable(redimensionavel);
		setVisible(visivel);
	}

	/**
	 * Empacota as configurações.
	 * @author Senio Caires
	 */
	private void empacotar() {
		pack();
	}

	/**
	 * Retorna o container.
	 * @author Senio Caires
	 * @return {@link Container}
	 */
	private Container obterContainer() {
		return getContentPane();
	}

	/**
	 * Método para inicializar a aplicação.
	 * @author Senio Caires
	 * @param args - argumentos passados ao inicializar a aplicação não serão utilizados
	 */
	public static void main(String... args) {
		Main app = new Main();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Altera o texto cifrado para o texto passado como parâmetro.
	 * @author Senio Caires
	 * @param textoCifrado - Texto cifrado
	 */
	public void alterarTextoCifrado(String textoCifrado) {
		this.resultado.setText(textoCifrado);
	}

	/**
	 * Cifra e/ou decifra o texto que o usuário digitou.
	 * @author Senio Caires
	 */
	public void cifrarDecifrarTexto() {

		String textoCifrado = Main.cripDecrip(this.texto.getText());

		this.alterarTextoCifrado(textoCifrado);
	}

	/**
	 * Método para cifrar.
	 * @author Senio Caires
	 * @param mensagem - Mensagem a ser cifrada
	 * @return {@link String}
	 */
	private static String cripDecrip(String mensagem) {

		StringBuilder resultado = new StringBuilder();

		for (char character : mensagem.toCharArray()) {

			if (hash.get(character) == null) {
				resultado.append(character);
			} else {
				resultado.append(hash.get(character));
			}
		}

		return resultado.reverse().toString();
	}

	/**
	 * Retorna text area do resultado da cifra.
	 * @author Senio Caires
	 * @return {@link JTextArea}
	 */
	public JTextArea getResultado() {
		return this.resultado;
	}

	/**
	 * Retorna o text area do texto digitado pelo usuário.
	 * @author Senio Caires
	 * @return {@link JTextArea}
	 */
	public JTextArea getTexto() {
		return this.texto;
	}
}
