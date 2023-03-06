package seedu.recipe.model.recipe;

import static seedu.recipe.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Objects;


/**
 * Represents a Recipe in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Recipe {

    // Identity fields
    private final Title title;
    private final Description desc;

    // Data fields
    private final ArrayList<Ingredient> ingredients;
    private final ArrayList<Step> steps;

    /**
     * Every field must be present and not null.
     */
    public Recipe(Title title, Description desc, ArrayList<Ingredient> ingredients, ArrayList<Step> steps) {
        requireAllNonNull(title, desc, ingredients, steps);
        this.title = title;
        this.desc = desc;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public Title getTitle() {
        return this.title;
    }

    public Description getDesc() {
        return this.desc;
    }

    public ArrayList<Ingredient> getIngredients() {
        return this.ingredients;
    }
    public ArrayList<Step> getSteps() {
        return this.steps;
    }

    /**
     * Returns true if both recipes have the same title.
     * This defines a weaker notion of equality between two recipes.
     */
    public boolean isSameRecipe(Recipe otherRecipe) {
        if (otherRecipe == this) {
            return true;
        }

        return otherRecipe != null
                && otherRecipe.getTitle().equals(getTitle());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Recipe)) {
            return false;
        }

        Recipe otherRecipe = (Recipe) other;
        return otherRecipe.getTitle().equals(getTitle())
                && otherRecipe.getDesc().equals(getDesc())
                && otherRecipe.getIngredients().equals(getIngredients())
                && otherRecipe.getSteps().equals(getSteps());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(title, desc, ingredients, steps);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getTitle())
                .append("; Description: ")
                .append(getDesc());

        ArrayList<Ingredient> ingredients = getIngredients();
        if (!ingredients.isEmpty()) {
            builder.append("; Tags: ");
            ingredients.forEach(builder::append);
        }

        ArrayList<Step> steps = getSteps();
        if (!steps.isEmpty()) {
            builder.append("; Tags: ");
            steps.forEach(builder::append);
        }
        return builder.toString();
    }

}