package diamond_kata;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DiamondTest {

    private Diamond diamond;

    @Test
    public void should_draw_a_diamond_starting_with_A_with_the_supplied_letter_at_the_widest_point() {
        assertThat(diamond.draw('C'), is(equalTo(
                "  A  \n" +
                " B B \n" +
                "C   C\n" +
                " B B \n" +
                "  A  \n")));
    }

    @Test
    public void should_build_a_slab_from_a_given_letter_used_to_sculpt_the_diamond() {
        assertThat(diamond.buildSlab('C'), is(new char[][]{
                new char[] {'C', 'B', 'A', 'B', 'C'},
                new char[] {'C', 'B', 'A', 'B', 'C'},
                new char[] {'C', 'B', 'A', 'B', 'C'},
                new char[] {'C', 'B', 'A', 'B', 'C'},
                new char[] {'C', 'B', 'A', 'B', 'C'}
        }));
    }

    @Test
    public void should_create_a_line_from_a_given_letter_to_A_and_from_A_back_to_the_letter() {
        assertThat(diamond.createLine('C'), is(equalTo(new char[] {'C', 'B', 'A', 'B', 'C'})));
        assertThat(diamond.createLine('A'), is(equalTo(new char[] {'A'})));
    }

    @Test
    public void should_calculate_diamond_diameter() {
        assertThat(diamond.calculateDiameter('C'), is(5));
        assertThat(diamond.calculateDiameter('B'), is(3));
        assertThat(diamond.calculateDiameter('A'), is(1));
    }

    @Test
    public void should_build_a_column_used_to_filter_the_letters_in_the_slab() {
        assertThat(diamond.createColumnFilter('C'), is(equalTo(new char[] {'A', 'B', 'C', 'B', 'A'})));
        assertThat(diamond.createColumnFilter('B'), is(equalTo(new char[] {'A', 'B', 'A'})));
        assertThat(diamond.createColumnFilter('A'), is(equalTo(new char[] {'A'})));
    }

    @Test
    public void should_filter_slab() {
        char[] columnFilter = new char[] {'A', 'B', 'C', 'B', 'A'};
        char[][] slab = new char[][]{
                new char[] {'C', 'B', 'A', 'B', 'C'},
                new char[] {'C', 'B', 'A', 'B', 'C'},
                new char[] {'C', 'B', 'A', 'B', 'C'},
                new char[] {'C', 'B', 'A', 'B', 'C'},
                new char[] {'C', 'B', 'A', 'B', 'C'}
        };

        assertThat(diamond.filter(slab, columnFilter), is(equalTo(
                new char[][]{
                        new char[] {' ', ' ', 'A', ' ', ' '},
                        new char[] {' ', 'B', ' ', 'B', ' '},
                        new char[] {'C', ' ', ' ', ' ', 'C'},
                        new char[] {' ', 'B', ' ', 'B', ' '},
                        new char[] {' ', ' ', 'A', ' ', ' '}
                })));
    }

    @Test
    public void should_transform_a_table_into_string() {
        char[][] slab = new char[][]{
                new char[] {' ', ' ', 'A', ' ', ' '},
                new char[] {' ', 'B', ' ', 'B', ' '},
                new char[] {'C', ' ', ' ', ' ', 'C'},
                new char[] {' ', 'B', ' ', 'B', ' '},
                new char[] {' ', ' ', 'A', ' ', ' '}
        };

        assertThat(diamond.stringify(slab), is(equalTo(
                "  A  \n" +
                " B B \n" +
                "C   C\n" +
                " B B \n" +
                "  A  \n")));
    }

    @Before
    public void setUp() {
        diamond = new Diamond();
    }
}
