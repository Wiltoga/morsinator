package morsinator.collections;

import morsinator.reader.ConversionRow;
import morsinator.collections.generics.MorsiList;

public class ConversionList extends MorsiList<ConversionRow> implements TextConversion {
    public String getMorse(char letter) {
        for(Node<ConversionRow> node = getFirst(); node != null; node = node.getNext()) {
            ConversionRow row = node.getValue();

            if(row.letter == letter) {
                return row.morse;
            }
        }

        return null;
    }
}