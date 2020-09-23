package nl.testchamber.mailordercoffeeshop.test

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.GeneralLocation
import androidx.test.espresso.action.GeneralSwipeAction
import androidx.test.espresso.action.Press
import androidx.test.espresso.action.Swipe
import androidx.test.espresso.matcher.ViewMatchers
import nl.testchamber.mailordercoffeeshop.R
import nl.testchamber.mailordercoffeeshop.TestRunner
import nl.testchamber.mailordercoffeeshop.screen.CustomOrderScreen
import nl.testchamber.mailordercoffeeshop.screen.ReviewOrderScreen
import org.junit.Test

class ReviewCustomOrderTest : TestRunner() {

    @Test
    fun testOrderOneShot() {
        run {
            step("Add 1 shot") {
                CustomOrderScreen {
                    plusButton {
                        click()
                    }
                }
            }
            step("Click on review button") {
                CustomOrderScreen {
                    reviewButton {
                        click()
                    }
                }
            }
            step("Check information about order on Review Screen") {
                ReviewOrderScreen {
                    detailTitle {
                        hasText("Your custom drink")
                    }
                    detailVolume {
                        hasText("30 ML.")
                    }
                    detailIngredients {
                        hasText("Ingredients:\n" +
                                "1 shot of espresso")
                    }
                }
            }
        }
    }

    @Test
    fun testOrderOneColdShot() {
        run {
            step("Add 1 shot") {
                CustomOrderScreen {
                    plusButton {
                        click()
                    }
                }
            }
            step("Choose cold espresso") {
                CustomOrderScreen {
                    temperatureCheckbox {
                        click()
                    }
                }
            }
            step("Click on review button") {
                CustomOrderScreen {
                    reviewButton {
                        click()
                    }
                }
            }
            step("Check information about order on Review Screen") {
                ReviewOrderScreen {
                    detailTitle {
                        hasText("Your custom drink")
                    }
                    detailVolume {
                        hasText("30 ML.")
                    }
                    detailIngredients {
                        hasText("Ingredients:\n" +
                                "1 shot of cold espresso")
                    }
                }
            }
        }
    }

    @Test
    fun testOrderSomeShotWithChocolate() {
        run {
            step("Add 3 shots") {
                CustomOrderScreen {
                    plusButton {
                        click()
                        click()
                        click()
                    }
                }
            }
            step("Add chocolate") {
                CustomOrderScreen {
                    chocolateCheckbox {
                        click()
                    }
                }
            }
            step("Click on review button") {
                CustomOrderScreen {
                    reviewButton {
                        click()
                    }
                }
            }
            step("Check information about order on Review Screen") {
                ReviewOrderScreen {
                    detailTitle {
                        hasText("Your custom drink")
                    }
                    detailVolume {
                        hasText("120 ML.")
                    }
                    detailIngredients {
                        hasText("Ingredients:\n" +
                                "3 shots of espresso\n" +
                                "Chocolate")
                    }
                }
            }
        }
    }

    @Test
    fun testOrderSomeShotWithMilk() {
        run {
            step("Add 6 shots") {
                CustomOrderScreen {
                    plusButton {
                        click()
                        click()
                        click()
                        click()
                        click()
                        click()
                        click()
                        click()
                    }
                    minusButton {
                        click()
                        click()
                    }
                }
            }
            step("Add milk - Low Fat") {
                CustomOrderScreen {
                    milkTypeTextView {
                        click()
                    }
                    lowFatDropDownItem {
                        click()
                    }
                }
            }
            step("Click on review button") {
                CustomOrderScreen {
                    reviewButton {
                        click()
                    }
                }
            }
            step("Check information about order on Review Screen") {
                ReviewOrderScreen {
                    detailTitle {
                        hasText("Your custom drink")
                    }
                    detailVolume {
                        hasText("210 ML.")
                    }
                    detailIngredients {
                        hasText("Ingredients:\n" +
                                "6 shots of espresso\n" +
                                " Low fat")
                    }
                }
            }
        }
    }

    @Test
    fun testOrderShotWithFoamedMilk() {
        run {
            step("Add 1 shot") {
                CustomOrderScreen {
                    plusButton {
                        click()
                    }
                }
            }
            step("Add milk - Low Fat") {
                CustomOrderScreen {
                    milkTypeTextView {
                        click()
                    }
                    lowFatDropDownItem {
                        click()
                    }
                    foamedRadioButton {
                        click()
                    }
                }
            }
            step("Click on review button") {
                CustomOrderScreen {
                    reviewButton {
                        click()
                    }
                }
            }
            step("Check information about order on Review Screen") {
                ReviewOrderScreen {
                    detailTitle {
                        hasText("Your custom drink")
                    }
                    detailVolume {
                        hasText("60 ML.")
                    }
                    detailIngredients {
                        hasText("Ingredients:\n" +
                                "1 shot of espresso\n" +
                                "Foamed Low fat")
                    }
                }
            }
        }
    }

    @Test
    fun testOrderShotWithCustomMilk() {
        run {
            step("Add 1 shot") {
                CustomOrderScreen {
                    plusButton {
                        click()
                    }
                }
            }
            step("Add custom milk") {
                CustomOrderScreen {
                    milkTypeTextView {
                        click()
                    }
                    customDropDownItem {
                        click()
                    }
                }
            }
            step("Click on review button") {
                CustomOrderScreen {
                    reviewButton {
                        click()
                    }
                }
            }
            step("Check information about order on Review Screen") {
                ReviewOrderScreen {
                    detailTitle {
                        hasText("Your custom drink")
                    }
                    detailVolume {
                        hasText("60 ML.")
                    }
                    detailIngredients {
                        hasText("Ingredients:\n" +
                                "1 shot of espresso\n" +
                                " 0% fat milk")
                    }
                }
            }
        }
    }

    @Test
    fun testOrderShotWithCustomMilkAddFat() {
        run {
            step("Add 1 shot") {
                CustomOrderScreen {
                    plusButton {
                        click()
                    }
                }
            }
            step("Add custom milk") {
                CustomOrderScreen {
                    milkTypeTextView {
                        click()
                    }
                    customDropDownItem {
                        click()
                    }
                    onView(ViewMatchers.withId(R.id.simpleSeekBar))
                            .perform(GeneralSwipeAction(
                                    Swipe.SLOW,
                                    GeneralLocation.TOP_LEFT,
                                    GeneralLocation.TOP_CENTER,
                                    Press.FINGER))
                }
            }
            step("Click on review button") {
                CustomOrderScreen {
                    reviewButton {
                        click()
                    }
                }
            }
            step("Check information about order on Review Screen") {
                ReviewOrderScreen {
                    detailTitle {
                        hasText("Your custom drink")
                    }
                    detailVolume {
                        hasText("60 ML.")
                    }
                    detailIngredients {
                        hasText("Ingredients:\n" +
                                "1 shot of espresso\n" +
                                " Cottage Cheese")
                    }
                }
            }
        }
    }

    @Test
    fun testOrderWithAllOptions() {
        run {
            step("Add 3 shots") {
                CustomOrderScreen {
                    plusButton {
                        click()
                        click()
                        click()
                    }
                }
            }
            step("Choose cold espresso") {
                CustomOrderScreen {
                    temperatureCheckbox {
                        click()
                    }
                }
            }
            step("Add chocolate") {
                CustomOrderScreen {
                    chocolateCheckbox {
                        click()
                    }
                }
            }
            step("Add custom whipped milk with fat") {
                CustomOrderScreen {
                    milkTypeTextView {
                        click()
                    }
                    customDropDownItem {
                        click()
                    }
                    whippedRadioButton {
                        click()
                    }
                    onView(ViewMatchers.withId(R.id.simpleSeekBar))
                            .perform(GeneralSwipeAction(
                                    Swipe.SLOW,
                                    GeneralLocation.TOP_LEFT,
                                    GeneralLocation.TOP_CENTER,
                                    Press.FINGER))
                }
            }
            step("Click on review button") {
                CustomOrderScreen {
                    reviewButton {
                        click()
                    }
                }
            }
            step("Check information about order on Review Screen") {
                ReviewOrderScreen.detailTitle {
                    hasText("Your custom drink")
                }
                ReviewOrderScreen.detailVolume {
                    hasText("150 ML.")
                }
                ReviewOrderScreen.detailIngredients {
                    hasText("Ingredients:\n" +
                            "3 shots of cold espresso\n" +
                            "Chocolate\n" +
                            "Whipped Cottage Cheese")
                }
            }
        }
    }
}