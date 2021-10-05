package morsinator.collections;

import morsinator.collections.generics.MorsiBinaryTree;

import java.util.function.*;
import java.util.*;

import morsinator.MorsinatorParseException;

public class ConversionBinaryTree extends MorsiBinaryTree<String, Character> implements MorseConversion {
    /**
     * Simple délégué pour convertir une clé en morse en une route
     * 
     * @param key clé d'un valeur d'un arbre binaire
     * @return route vers la valeur
     */
    private final static Function<String, List<Boolean>> morseConvert = (key) -> {
        List<Boolean> result = new ArrayList<>(key.length());
        for (int i = 0; i < key.length(); ++i) {
            char current = key.charAt(i);
            switch (current) {
                case '_':
                case '-':
                    result.add(false);
                    break;
                case '.':
                    result.add(true);
                    break;
                default:
                    return null;
            }
        }
        return result;
    };

    public ConversionBinaryTree() {
        super(morseConvert);
    }

    public void addRow(char letter, String morse) throws MorsinatorParseException {
        try {
            if(containsKey(morse)) {
                throw new MorsinatorParseException("Code morse de '" + letter + "' déjà ajouté sous la lettre '" + get(morse) + "'");
            } else {
                set(morse, letter);
            }
        } catch(IllegalArgumentException e) {
            throw new MorsinatorParseException("Le code \"" + morse + "\" n'est pas un code morse valide, impossible de le sauvegarder dans l'arbre");
        }
    }

    public Character getLetter(String morse) {
        try {
            return get(morse);
        } catch(NoSuchElementException | IllegalArgumentException e) {
            return null;
        }
    }
}
