package main;

public class Category {
    private String title;
    private Category parentCategory;

    public Category(String title) {
        this.setTitle(title);
    }

    public Category(String title, Category parentCategory) {
        this.title = title;
        this.parentCategory = parentCategory;
    }

    /**
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return parentCategory
     */
    public Category getParentCategory() {

        return parentCategory;
    }

    /**
     *
     * @param title;
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @param parentCategory;
     */
    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }
}
