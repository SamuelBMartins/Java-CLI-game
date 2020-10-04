package ch.supsi.game.logic;

import ch.supsi.game.ui.elements.Element;

/**
 * @author Samuel
 *
 *Utilizzata per le lambda expression nella creazione degli oggetti sulla griglia
 */
@FunctionalInterface
public interface GenerateElement {
	Element getElement();
}
