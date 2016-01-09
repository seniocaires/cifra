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

	public Tratador(Main app) {
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		String textoCifrado = cripDecrip(this.app.getTextoEscrito());

		this.app.alterarTextoCifrado(textoCifrado);
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
