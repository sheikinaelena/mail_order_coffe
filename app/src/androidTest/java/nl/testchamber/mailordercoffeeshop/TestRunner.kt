package nl.testchamber.mailordercoffeeshop

import android.app.Activity
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.platform.app.InstrumentationRegistry
import com.kaspersky.kaspresso.testcases.api.testcase.BaseTestCase
import org.junit.Rule


open class TestRunner(
        isFirstLaunch: Boolean = false
) : BaseTestCase<Unit, Unit>(
        dataProducer = { action -> action?.invoke(Unit) }
) {

    @get:Rule
    val activityRule: IntentsTestRule<MainActivity> =
            object : IntentsTestRule<MainActivity>(MainActivity::class.java, true, true) {
                override fun beforeActivityLaunched() {
                    super.beforeActivityLaunched()
                    val context = InstrumentationRegistry.getInstrumentation().targetContext
                    val editor = context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE).edit()
                    editor.putBoolean("is_first_launch", isFirstLaunch)
                    editor.commit()
                }
            }
}
