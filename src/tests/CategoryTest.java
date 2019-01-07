package tests;

import main.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    private Category electronic;

    @BeforeEach
    public void setUp() {
        electronic = new Category("electronic");
    }

    @AfterEach
    public void tearDown() {
        electronic = null;
    }

    @Test
    public void testIsCategoryTitleCorrectWhenInitialize() {
        assertEquals("electronic", electronic.getTitle());
    }

    @Test
    public void testIsParentCategoryCorrectWhenInitialize() {
        Category cable = new Category("cable", electronic);
        assertEquals(electronic, cable.getParentCategory());
    }

    @Test
    public void testIsParentCategoryNullWhenNotInitialize() {
        assertEquals(null, electronic.getParentCategory());
    }
}