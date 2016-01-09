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

/**
 * Action Listener.
 * @author Senio Caires
 */
public class Tratador implements ActionListener {

	/**
	 * App.
	 * @author Senio Caires
	 */
	private final transient Main app;

	/**
	 * Construir informando a app.
	 * @author Senio Caires
	 * @param app - Aplicação
	 */
	public Tratador(Main app) {
		this.app = app;
	}

	/**
	 * Action Performed.
	 * @author Senio Caires
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		this.app.cifrarDecifrarTexto();
	}
}
