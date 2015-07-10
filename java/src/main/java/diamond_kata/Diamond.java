package diamond_kata;

import java.util.Arrays;
import java.util.Stack;

public class Diamond {
    public static void main( String[] args )
    {
        if(args.length != 1) {
            throw new IllegalArgumentException("invalid input: " + Arrays.toString(args) + ". Must be a single character.");
        }

        Diamond diamond = new Diamond();
        System.out.println( diamond.draw(args[0]) );
    }

    public String draw(String letter) {
        return draw(letter.charAt(0));
    }

    public String draw(char letter) {
        char[][] slab = buildSlab(letter);
        char[] columnFilter = createColumnFilter(letter);
        char[][] diamond = filter(slab, columnFilter);
        return stringify(diamond);
    }

    String stringify(char[][] diamond) {
        String output = "";
        final char lineFeed = '\n';

        for (int line = 0; line < diamond.length; line++) {
            for(int column = 0; column < diamond[line].length; column++) {
                output += diamond[line][column];
            }

            output += lineFeed;
        }

        return output;
    }

    char[][] filter(char[][] slap, char[] columnFilter) {
        char[][] filteredSlab = new char[slap.length][];
        char whitespace = ' ';

        for (int line = 0; line < slap.length; line++) {
            char displayedLetter = columnFilter[line];
            filteredSlab[line] = new char[slap[line].length];

            for(int column = 0; column < slap[line].length; column++) {
                if(slap[line][column] == displayedLetter) {
                    filteredSlab[line][column] = slap[line][column];
                }

                else {
                    filteredSlab[line][column] = whitespace;
                }
            }
        }

        return filteredSlab;
    }

    char[] createColumnFilter(char letter) {
        int diameter = calculateDiameter(letter);
        char[] line = new char[diameter];
        Stack<Character> stack = new Stack<Character>();

        int i = 0;
        for(int c = (int)'A'; c < (int)letter; c++) {
            line[i++] = (char) c;
            stack.push((char) c);
        }

        stack.push(letter);

        while(!stack.isEmpty()) {
            line[i++] = stack.pop();
        }

        return line;
    }

    char[][] buildSlab(char letter) {
        char[] line = createLine(letter);
        int numberOfLines = calculateDiameter(letter);
        char[][] slab = new char[numberOfLines][];

        for(int l = 0; l < numberOfLines; l++) {
            slab[l] = line;
        }

        return slab;
    }

    int calculateDiameter(char letter) {
        return ((int)letter - (int)'A' + 1) * 2 - 1;
    }

    char[] createLine(char letter) {
        int diameter = calculateDiameter(letter);
        char[] line = new char[diameter];
        Stack<Character> stack = new Stack<Character>();

        int i = 0;
        for(int c = (int) letter; c > (int) 'A'; c--) {
            line[i++] = (char) c;
            stack.push((char) c);
        }

        stack.push('A');

        while(!stack.isEmpty()) {
            line[i++] = stack.pop();
        }

        return line;
    }
}
