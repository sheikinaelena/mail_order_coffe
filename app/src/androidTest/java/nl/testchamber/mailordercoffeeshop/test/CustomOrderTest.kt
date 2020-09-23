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
import org.junit.Test

class CustomOrderTest : TestRunner() {

    @Test
    fun testCountOfShots() {
        run {
            step("Check count of shots after loading screen") {
                CustomOrderScreen {
                    espressoShotCounterTextView {
                        hasText("0")
                    }
                }
            }
            step("Check count of shots after add on plus button") {
                CustomOrderScreen {
                    plusButton {
                        click()
                    }
                    espressoShotCounterTextView {
                        hasText("1")
                    }
                }
            }
            step("Check count of shots after add on plus button many times") {
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
                    espressoShotCounterTextView {
                        hasText("9")
                    }
                }
            }
            step("Check count of shots after add on minus button") {
                CustomOrderScreen {
                    minusButton {
                        click()
                    }
                    espressoShotCounterTextView {
                        hasText("8")
                    }
                }
            }
            step("Check count of shots after add on minus button many times") {
                CustomOrderScreen {
                    minusButton {
                        click()
                        click()
                        click()
                        click()
                        click()
                        click()
                    }
                    espressoShotCounterTextView {
                        hasText("2")
                    }
                }
            }
            step("Check count of shots after add on minus button if count = 0") {
                CustomOrderScreen {
                    minusButton {
                        click()
                        click()
                        click()
                    }
                    espressoShotCounterTextView {
                        hasText("0")
                    }
                }
            }
        }
    }

    @Test
    fun testDisplayMilkConditions() {
        run {
            step("Check milk conditions after loading of screen") {
                CustomOrderScreen {
                    customFatTextView {
                        isNotDisplayed()
                    }
                    milkСonditionsRadioButtons {
                        isNotDisplayed()
                    }
                }
            }
            step("Choose type of milk - Low Fat") {
                CustomOrderScreen {
                    milkTypeTextView {
                        click()
                    }
                    lowFatDropDownItem {
                        click()
                    }
                }
            }
            step("Check milk conditions after choosing type of milk. Not Custom") {
                CustomOrderScreen {
                    customFatTextView {
                        isNotDisplayed()
                    }
                    milkСonditionsRadioButtons {
                        isDisplayed()
                    }
                }
            }
            step("Choose type of milk - Custom") {
                CustomOrderScreen {
                    milkTypeTextView {
                        click()
                    }
                    customDropDownItem {
                        click()
                    }
                }
            }
            step("Check milk conditions after choosing custom milk") {
                CustomOrderScreen {
                    customFatTextView {
                        isDisplayed()
                    }
                    milkСonditionsRadioButtons {
                        isDisplayed()
                    }
                }
            }
        }
    }

    @Test
    fun testCustomFatValue() {
        run {
            step("Choose type of milk - Custom") {
                CustomOrderScreen {
                    milkTypeTextView {
                        click()
                    }
                    customDropDownItem {
                        click()
                    }
                }
            }
            step("Check fat percentage text after choosing custom milk") {
                CustomOrderScreen {
                    customFatPercentageTextTextView {
                        hasText("Milk fat percentage: 0")
                    }
                }
            }
            step("Check fat percentage text after choosing fat of milk") {
                CustomOrderScreen {
                    onView(ViewMatchers.withId(R.id.simpleSeekBar))
                            .perform(GeneralSwipeAction(
                                    Swipe.SLOW,
                                    GeneralLocation.TOP_LEFT,
                                    GeneralLocation.TOP_CENTER,
                                    Press.FINGER
                            ))
                    customFatPercentageTextTextView {
                        hasText("Milk fat percentage: 20")
                    }
                }
            }
        }
    }

}