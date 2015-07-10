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

    @Before
    public void setUp() {
        diamond = new Diamond();
    }
}
