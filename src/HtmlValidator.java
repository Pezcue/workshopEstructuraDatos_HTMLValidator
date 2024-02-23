import java.util.Queue;
import java.util.Stack;

public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		/* IMPLEMENT THIS METHOD! */

		Stack<HtmlTag> pilaAperturas = new Stack<>();

		for (HtmlTag etiqueta : tags) {
			if (etiqueta.isSelfClosing()) {
				continue;
			} else if (etiqueta.isOpenTag()) {
				pilaAperturas.push(etiqueta);
			} else if (!etiqueta.isOpenTag()) {
				if (!pilaAperturas.isEmpty()) {
					if (pilaAperturas.peek().matches(etiqueta)) {
						pilaAperturas.pop();
					} else {
						return pilaAperturas;
					}
				} else {
					return null;
				}
			}

		}
		return pilaAperturas; // this line is here only so this code will compile if you don't modify it
	}

}
