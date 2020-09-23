package nl.testchamber.mailordercoffeeshop.test

import android.content.Intent
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import nl.testchamber.mailordercoffeeshop.TestRunner
import nl.testchamber.mailordercoffeeshop.screen.CustomOrderScreen
import nl.testchamber.mailordercoffeeshop.screen.HeaderScreen
import nl.testchamber.mailordercoffeeshop.screen.MenuScreen
import nl.testchamber.mailordercoffeeshop.screen.ReviewOrderScreen
import org.hamcrest.CoreMatchers
import org.hamcrest.core.AllOf
import org.junit.Test

class OrderCoffeeTest : TestRunner() {

    @Test
    fun testEmptyCustomOrder() {
        run {
            step("Click on Review button") {
                CustomOrderScreen {
                    reviewButton {
                        click()
                    }
                }
            }
            step("Check that Review Screen not open") {
                ReviewOrderScreen {
                    detailTitle {
                        doesNotExist()
                    }
                }
            }
            step("Click on Send button") {
                CustomOrderScreen {
                    reviewButton {
                        isVisible()
                    }
                }
            }
        }
    }

    @Test
    fun testOrderCoffeeFromMenu() {
        run {
            step("Click on Menu Button in header") {
                HeaderScreen {
                    menuButton {
                        click()
                    }
                }
            }
            step("Click on item from menu") {
                MenuScreen {
                    menuRecyclerView.childAt<MenuScreen.MenuItem>(5) {
                        click()
                    }
                }
            }
            step("Check Review Screen") {
                ReviewOrderScreen {
                    detailTitle {
                        hasText("Café Creme")
                    }
                    detailVolume {
                        hasText("90 ML.")
                    }
                    detailIngredients {
                        hasText("Ingredients:\n2 shots of espresso\nHeavy cream")
                    }
                    nameTextBox {
                        hasText("")
                    }
                    emailTextBox {
                        hasText("")
                    }
                    customOrderTextBox {
                        isNotDisplayed()
                    }
                }
            }
            step("Set name and email") {
                ReviewOrderScreen {
                    nameTextBox {
                        typeText("My name")
                    }
                    emailTextBox {
                        typeText("test@test.com")
                    }
                }
            }
            step("Check on send button") {
                ReviewOrderScreen {
                    mailOrderButton {
                        click()
                    }
                }
            }
            step("Check sending information") {
                Intents.intended(AllOf.allOf(
                        IntentMatchers.hasAction(CoreMatchers.equalTo(Intent.ACTION_SENDTO)),
                        IntentMatchers.hasExtra(Intent.EXTRA_EMAIL, listOf("coffeeshop@valori.nl", "test@test.com").toTypedArray()),
                        IntentMatchers.hasExtra(Intent.EXTRA_SUBJECT, "Order: My name - Café Creme"),
                        IntentMatchers.hasExtra(Intent.EXTRA_TEXT, "Ingredients:\n2 shots of espresso\nHeavy cream")))
            }
        }
    }

    @Test
    fun testOrderCoffeeFromMenuWithoutEmail() {
        run {
            step("Click on Menu Button in header") {
                HeaderScreen {
                    menuButton {
                        click()
                    }
                }
            }
            step("Click on item from menu") {
                MenuScreen {
                    menuRecyclerView.childAt<MenuScreen.MenuItem>(5) {
                        click()
                    }
                }
            }
            step("Set name") {
                ReviewOrderScreen {
                    nameTextBox {
                        typeText("My name")
                    }
                }
            }
            step("Check on send button") {
                ReviewOrderScreen {
                    mailOrderButton {
                        click()
                    }
                }
            }
            step("Check sending information") {
                Intents.intended(AllOf.allOf(
                        IntentMatchers.hasAction(CoreMatchers.equalTo(Intent.ACTION_SENDTO)),
                        IntentMatchers.hasExtra(Intent.EXTRA_EMAIL, listOf("coffeeshop@valori.nl").toTypedArray()),
                        IntentMatchers.hasExtra(Intent.EXTRA_SUBJECT, "Order: My name - Café Creme"),
                        IntentMatchers.hasExtra(Intent.EXTRA_TEXT, "Ingredients:\n2 shots of espresso\nHeavy cream")))
            }
        }
    }

    @Test
    fun testOrderCoffeeFromMenuWithoutName() {
        run {
            step("Click on Menu Button in header") {
                HeaderScreen {
                    menuButton {
                        click()
                    }
                }
            }
            step("Click on item from menu") {
                MenuScreen {
                    menuRecyclerView.childAt<MenuScreen.MenuItem>(5) {
                        click()
                    }
                }
            }
            step("Click on send button") {
                ReviewOrderScreen {
                    mailOrderButton {
                        click()
                    }
                }
            }
            step("Set email") {
                ReviewOrderScreen {
                    emailTextBox {
                        typeText("test@test.ru")
                    }
                }
            }
            step("Check sending information") {
                ReviewOrderScreen {
                    nameTextInputLayout {
                        hasError("Enter your name please")
                    }
                }
            }
        }
    }

    @Test
    fun testOrderCustomCoffee() {
        run {
            step("Create custom order") {
                CustomOrderScreen {
                    plusButton {
                        click()
                        click()
                        click()
                    }
                    temperatureCheckbox {
                        click()
                    }
                    chocolateCheckbox {
                        click()
                    }
                    milkTypeTextView {
                        click()
                    }
                    lowFatDropDownItem {
                        click()
                    }
                    scaldedRadioButton {
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
            step("Check Review Screen") {
                ReviewOrderScreen {
                    detailIngredients {
                        hasText("Ingredients:\n3 shots of cold espresso\nChocolate\nScalded Low fat")
                    }
                    nameTextBox {
                        hasText("")
                    }
                    emailTextBox {
                        hasText("")
                    }
                    customOrderTextBox {
                        hasText("")
                    }
                }
            }
            step("Set name and email") {
                ReviewOrderScreen {
                    nameTextBox {
                        typeText("My name")
                    }
                    emailTextBox {
                        typeText("test@test.com")
                    }
                    customOrderTextBox {
                        typeText("Custom Order Name")
                    }
                }
            }
            step("Check on send button") {
                ReviewOrderScreen {
                    mailOrderButton {
                        click()
                    }
                }
            }
            step("Check sending information") {
                Intents.intended(AllOf.allOf(
                        IntentMatchers.hasAction(CoreMatchers.equalTo(Intent.ACTION_SENDTO)),
                        IntentMatchers.hasExtra(Intent.EXTRA_EMAIL, listOf("coffeeshop@valori.nl", "test@test.com").toTypedArray()),
                        IntentMatchers.hasExtra(Intent.EXTRA_SUBJECT, "Order: My name - Custom Order Name"),
                        IntentMatchers.hasExtra(Intent.EXTRA_TEXT, "Ingredients:\n3 shots of cold espresso\nChocolate\nScalded Low fat")))
            }
        }
    }

    @Test
    fun testOrderCustomCoffeeWithoutCustomOrderName() {
        run {
            step("Create custom order") {
                CustomOrderScreen {
                    plusButton {
                        click()
                    }
                    reviewButton {
                        click()
                    }
                }
            }
            step("Set email and name") {
                ReviewOrderScreen {
                    emailTextBox {
                        typeText("test@test.ru")
                    }
                    nameTextBox {
                        typeText("my name")
                    }
                }
            }
            step("Click on send button") {
                ReviewOrderScreen {
                    mailOrderButton {
                        click()
                    }
                }
            }
            step("Check sending information") {
                ReviewOrderScreen {
                    customOrderInputLayout {
                        hasError("Please enter a name for your order")
                    }
                }
            }
        }
    }

}