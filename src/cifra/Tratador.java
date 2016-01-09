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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Tratador implements ActionListener {

	private transient final Main app;

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
	}

	static {

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
	}

	static {

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

		hash.put('é', '+');
		hash.put('+', 'é');
		hash.put('É', '4');
		hash.put('4', 'É');
	}

	static {

		hash.put('5', '#');
		hash.put('#', '5');

		hash.put('0', '!');
		hash.put('!', '0');

		hash.put('ã', '?');
		hash.put('?', 'ã');
		hash.put('Ã', '3');
		hash.put('3', 'Ã');

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
	}

	static {
		hash.put(' ', ',');
		hash.put(',', ' ');

		hash.put('ç', 'ó');
		hash.put('ó', 'ç');
		hash.put('Ç', 'Ó');
		hash.put('Ó', 'Ç');

		hash.put('ê', ';');
		hash.put(';', 'ê');
		hash.put('Ê', '{');
		hash.put('{', 'Ê');

		hash.put('í', '}');
		hash.put('}', 'í');
		hash.put('Í', '[');
		hash.put('[', 'Í');
	}

	static {
		hash.put('ú', '<');
		hash.put('<', 'ú');
		hash.put('Ú', '(');
		hash.put('(', 'Ú');

		hash.put('á', '>');
		hash.put('>', 'á');
		hash.put('Á', ')');
		hash.put(')', 'Á');

		hash.put('@', '|');
		hash.put('|', '@');

		hash.put('ª', '¬');
		hash.put('¬', 'ª');

		hash.put('º', '§');
		hash.put('§', 'º');
	}

	public Tratador(Main app) {
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		this.app.getResultado().setText(cripDecrip(this.app.getTexto().getText()));
	}

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
}
