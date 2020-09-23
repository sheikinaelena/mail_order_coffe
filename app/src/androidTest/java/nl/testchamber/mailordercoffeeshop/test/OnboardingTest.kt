package nl.testchamber.mailordercoffeeshop.test


import nl.testchamber.mailordercoffeeshop.TestRunner
import nl.testchamber.mailordercoffeeshop.screen.*
import org.junit.Test

class OnboardingTest : TestRunner(isFirstLaunch = true) {

    @Test
    fun testCloseOnboarding() {
        run {
            step("Close onboarding") {
                OnboardingScreen {
                    closeButton {
                        click()
                    }
                }
            }
            step("Check that Custom Screen open") {
                CustomOrderScreen {
                    customOrderTitle {
                        hasText("Customize your order")
                    }
                }
            }
        }
    }

    @Test
    fun testDoneOnboarding() {
        run {
            step("Click on go on button") {
                OnboardingScreen {
                    goOnButton {
                        click()
                        click()
                    }
                }
            }
            step("Click on done button") {
                OnboardingScreen {
                    doneButton {
                        click()
                    }
                }
            }
            step("Check that Custom Screen open") {
                CustomOrderScreen {
                    customOrderTitle {
                        hasText("Customize your order")
                    }
                }
            }
        }
    }

    @Test
    fun testChooseTypeOrder() {
        run {
            step("Close onboarding") {
                OnboardingScreen {
                    closeButton {
                        click()
                    }
                }
            }
            step("Check that Custom Screen open") {
                CustomOrderScreen {
                    customOrderTitle {
                        hasText("Customize your order")
                    }
                }
            }
            step("Check that Custom Screen button is disable") {
                HeaderScreen {
                    customOrderButton {
                        isDisabled()
                    }
                }
            }
            step("Check that Menu button is enable") {
                HeaderScreen {
                    menuButton {
                        isEnabled()
                    }
                }
            }
            step("Click on Menu button") {
                HeaderScreen {
                    menuButton {
                        click()
                    }
                }
            }
            step("Check that Custom Screen button is enable") {
                HeaderScreen {
                    customOrderButton {
                        isEnabled()
                    }
                }
            }
            step("Check that Menu Screen button is disable") {
                HeaderScreen {
                    menuButton {
                        isDisabled()
                    }
                }
            }
            step("Check that Menu Screen open") {
                MenuScreen {
                    menuRecyclerView {
                        hasSize(23)
                    }
                }
            }
            step("Click on Custom order button") {
                HeaderScreen {
                    customOrderButton {
                        click()
                    }
                }
            }
            step("Check that Custom Screen open") {
                CustomOrderScreen {
                    customOrderTitle {
                        hasText("Customize your order")
                    }
                }
            }
            step("Check that Custom Screen button is disable") {
                HeaderScreen {
                    customOrderButton {
                        isDisabled()
                    }
                }
            }
            step("Check that Menu button is enable") {
                HeaderScreen {
                    menuButton {
                        isEnabled()
                    }
                }
            }
        }
    }

}