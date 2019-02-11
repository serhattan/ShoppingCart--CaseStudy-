package tests;

import main.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    private Category electronic;

    @BeforeEach
    void setUp() {
        electronic = new Category("electronic");
    }

    @Test
    void testIsCategoryTitleCorrectWhenInitialize() {
        assertEquals("electronic", electronic.getTitle());
    }

    @Test
    void testIsParentCategoryCorrectWhenInitialize() {
        Category cable = new Category("cable", electronic);
        assertEquals(electronic, cable.getParentCategory());
    }

    @Test
    void testIsParentCategoryNullWhenNotInitialize() {
        assertNull(electronic.getParentCategory());
    }
}