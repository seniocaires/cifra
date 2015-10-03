import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Data da primeira vers�o 04/07/2011.
 * @since 0.11.7.1
 * @version 0.11.7.4
 * @author Senio Caires
 */
public class Main extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextArea resultado;
	private JTextArea texto;
	private static Map<Character,Character> hash;

	static {

		hash = new HashMap<Character, Character>();

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

		hash.put('m', 'b');
		hash.put('b', 'm');
		hash.put('M', 'B');
		hash.put('B', 'M');

		hash.put('w', 'k');
		hash.put('k', 'w');
		hash.put('W', 'K');
		hash.put('K', 'W');

		hash.put('v', 't');
		hash.put('t', 'v');
		hash.put('V', 'T');
		hash.put('T', 'V');

		hash.put('h', 's');
		hash.put('s', 'h');
		hash.put('H', 'S');
		hash.put('S', 'H');

		hash.put('y', 'j');
		hash.put('j', 'y');
		hash.put('Y', 'J');
		hash.put('J', 'Y');

		hash.put('l', '8');
		hash.put('8', 'l');
		hash.put('L', '&');
		hash.put('&', 'L');

		hash.put('n', '~');
		hash.put('~', 'n');
		hash.put('N', '9');
		hash.put('9', 'N');

		hash.put('x', '6');
		hash.put('6', 'x');
		hash.put('X', '^');
		hash.put('^', 'X');

		hash.put('=', ']');
		hash.put(']', '=');

		hash.put('�', '+');
		hash.put('+', '�');
		hash.put('�', '4');
		hash.put('4', '�');

		hash.put('5', '#');
		hash.put('#', '5');

		hash.put('0', '!');
		hash.put('!', '0');

		hash.put('�', '?');
		hash.put('?', '�');
		hash.put('�', '3');
		hash.put('3', '�');

		hash.put('1', ':');
		hash.put(':', '1');

		hash.put('q', '/');
		hash.put('/', 'q');
		hash.put('Q', '.');
		hash.put('.', 'Q');

		hash.put('*', '7');
		hash.put('7', '*');

		hash.put('2', '$');
		hash.put('$', '2');

		hash.put(' ', ',');
		hash.put(',', ' ');

		hash.put('�', '�');
		hash.put('�', '�');
		hash.put('�', '�');
		hash.put('�', '�');

		hash.put('�', ';');
		hash.put(';', '�');
		hash.put('�', '{');
		hash.put('{', '�');

		hash.put('�', '}');
		hash.put('}', '�');
		hash.put('�', '[');
		hash.put('[', '�');

		hash.put('�', '<');
		hash.put('<', '�');
		hash.put('�', '(');
		hash.put('(', '�');

		hash.put('�', '>');
		hash.put('>', '�');
		hash.put('�', ')');
		hash.put(')', '�');

		hash.put('@', '|');
		hash.put('|', '@');

		hash.put('�', '�');
		hash.put('�', '�');

		hash.put('�', '�');
		hash.put('�', '�');
	}

	public Main() {

		super("Cifra");

		setResizable(false);

		Container tela = getContentPane();

		BorderLayout layout = new BorderLayout();
		tela.setLayout(layout);

		Tratador tratador = new Tratador();
		TratadorLimpar tratadorLimpar = new TratadorLimpar();

		JButton botaoConverter = new JButton("Converter");
		JButton botaoLimpar = new JButton("Limpar");
		botaoConverter.addActionListener(tratador);
		botaoLimpar.addActionListener(tratadorLimpar);

		resultado = new JTextArea(10, 20);
		texto = new JTextArea(10, 20);
		texto.setText("Digite o texto aqui.");

		resultado.setEditable(false);

		JScrollPane painelRolagemTexto = new JScrollPane(resultado);
		painelRolagemTexto.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		painelRolagemTexto.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		JScrollPane painelRolagemResultado = new JScrollPane(texto);
		painelRolagemResultado.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		painelRolagemResultado.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		JPanel pSuperior = new JPanel();
		pSuperior.setLayout(new FlowLayout(FlowLayout.TRAILING));
		pSuperior.add(painelRolagemResultado);

		JPanel pCentro = new JPanel();
		pCentro.setLayout(new FlowLayout(FlowLayout.TRAILING));
		pCentro.add(painelRolagemTexto);

		JPanel pInferiorBotao = new JPanel();
		pInferiorBotao.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pInferiorBotao.add(botaoLimpar);
		pInferiorBotao.add(botaoConverter);

		tela.add(BorderLayout.NORTH, pSuperior);
		tela.add(BorderLayout.CENTER, pCentro);
		tela.add(BorderLayout.SOUTH, pInferiorBotao);

		pack();
		setVisible(true);
	}

	public static void main(String args[]) {
		Main app = new Main();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class Tratador implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			resultado.setText(cripDecrip(texto.getText()));
		}
	}

	private class TratadorLimpar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			resultado.setText("");
			texto.setText("");
		}
	}

	private static String cripDecrip(String mensagem) {

		StringBuilder resultado = new StringBuilder();

		for (char character : mensagem.toCharArray()) {

			if (null != hash.get(character)) {
				resultado.append(hash.get(character));
			} else {
				resultado.append(character);
			}
		}

		return resultado.reverse().toString();
	}
}