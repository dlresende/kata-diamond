package diamond_kata;

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

    private char[] createColumnFilter(char letter) {
        throw new UnsupportedOperationException("not implemented");
    }

    private char[][] buildSlab(char letter) {
        throw new UnsupportedOperationException("not implemented");
    }
}
