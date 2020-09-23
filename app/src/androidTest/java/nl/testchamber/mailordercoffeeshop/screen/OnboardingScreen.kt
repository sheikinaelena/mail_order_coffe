package nl.testchamber.mailordercoffeeshop.screen

import android.view.View
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.kaspersky.kaspresso.screens.KScreen
import nl.testchamber.mailordercoffeeshop.R
import nl.testchamber.mailordercoffeeshop.onboarding.OnboardingFragment
import nl.testchamber.mailordercoffeeshop.order.beveragesmenu.MenuFragment
import org.hamcrest.Matcher

object OnboardingScreen: KScreen<OnboardingScreen>(){
    override val layoutId:Int? = R.layout.activity_onboarding
    override val viewClass:Class<*>?= OnboardingFragment::class.java

    val closeButton = KButton { withId(R.id.close_button) }
    val goOnButton = KButton { withId(R.id.go_on_button) }
    val doneButton = KButton { withId(R.id.done_button) }

}