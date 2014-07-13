package vebugger.templates;

import java.util.Currency;

import vebugger.VebuggerTemplate;

public class CurrencyTemplate extends VebuggerTemplate {

    @Override
    public Class<?> getType() {
        return Currency.class;
    }

    @Override
    public void render(StringBuilder sb, Object obj) {
        Currency currency = (Currency) obj;
        String currencyCode = currency.getCurrencyCode();
        String symbol = currency.getSymbol();
        String displayName = currency.getDisplayName();

        sb.append("<p><code>").append(symbol);
        if (!symbol.equals(currencyCode)) {
            sb.append(", ").append(currencyCode);
        }
        sb.append("</code></p><p>").append(displayName).append("</p>");
    }

}
