package diamond_kata;

import java.util.Stack;

public class Diamond {
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public String draw(char letter) {
        char[][] slab = buildSlab(letter);
        char[] columnFilter = createColumnFilter(letter);
        char[][] diamond = filter(slab, columnFilter);
        return stringify(diamond);
    }

    private String stringify(char[][] diamond) {
        throw new UnsupportedOperationException("not implemented");
    }

    private char[][] filter(char[][] slap, char[] columnFilter) {
        throw new UnsupportedOperationException("not implemented");
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
