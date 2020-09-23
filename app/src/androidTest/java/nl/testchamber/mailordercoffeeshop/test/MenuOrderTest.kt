package nl.testchamber.mailordercoffeeshop.test

import nl.testchamber.mailordercoffeeshop.TestRunner
import nl.testchamber.mailordercoffeeshop.screen.HeaderScreen
import nl.testchamber.mailordercoffeeshop.screen.MenuScreen
import nl.testchamber.mailordercoffeeshop.screen.ReviewOrderScreen
import org.junit.Test

class MenuOrderTest : TestRunner() {

    @Test
    fun testMenuItems() {
        run {
            step("Click on Menu Button in header") {
                HeaderScreen {
                    menuButton {
                        click()
                    }
                }
            }
            step("Check size of list") {
                MenuScreen {
                    menuRecyclerView {
                        hasSize(23)
                    }
                }
            }
            step("Check first item") {
                MenuScreen {
                    menuRecyclerView.childAt<MenuScreen.MenuItem>(0) {
                        itemVolumeTextView {
                            hasText("30 ml.")
                        }
                        itemNameTextView {
                            hasText("ESPRESSO")
                        }
                    }
                }
            }
            step("Check second item") {
                MenuScreen {
                    menuRecyclerView.childAt<MenuScreen.MenuItem>(1) {
                        itemVolumeTextView {
                            hasText("60 ml.")
                        }
                        itemNameTextView {
                            hasText("ESPRESSO DOPPIO")
                        }
                    }
                }
            }
            step("Check 15th item") {
                MenuScreen {
                    menuRecyclerView.childAt<MenuScreen.MenuItem>(14) {
                        itemVolumeTextView {
                            hasText("150 ml.")
                        }
                        itemNameTextView {
                            hasText("MOCHA")
                        }
                    }
                }
            }
            step("Check last item") {
                MenuScreen {
                    menuRecyclerView.childAt<MenuScreen.MenuItem>(22) {
                        itemVolumeTextView {
                            hasText("360 ml.")
                        }
                        itemNameTextView {
                            hasText("CAFÉ CON LECHE")
                        }
                    }
                }
            }
        }
    }

    @Test
    fun testChooseMenuItem() {
        run {
            step("Click on Menu Button in header") {
                HeaderScreen {
                    menuButton {
                        click()
                    }
                }
            }
            step("Choose item") {
                MenuScreen {
                    menuRecyclerView.childAt<MenuScreen.MenuItem>(17) {
                        click()
                    }
                }
            }
            step("Check review screen") {
                ReviewOrderScreen {
                    detailTitle {
                        hasText("Con Panna")
                    }
                    detailVolume {
                        hasText("150 ML.")
                    }
                    detailIngredients {
                        hasText("Ingredients:\n2 shots of espresso\nWhipped cream")
                    }
                }
            }
        }
    }
}