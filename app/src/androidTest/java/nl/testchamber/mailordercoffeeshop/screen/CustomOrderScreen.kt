package nl.testchamber.mailordercoffeeshop.screen

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers
import com.agoda.kakao.check.KCheckBox
import com.agoda.kakao.common.views.KView
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.kaspersky.kaspresso.screens.KScreen
import nl.testchamber.mailordercoffeeshop.R
import nl.testchamber.mailordercoffeeshop.order.customorder.CustomOrderFragment
import org.hamcrest.Matcher

object CustomOrderScreen: KScreen<CustomOrderScreen>(){
    override val layoutId: Int? =  R.layout.fragment_custom_order
    override val viewClass: Class<*>? = CustomOrderFragment::class.java

    val customOrderTitle = KTextView{ withId(R.id.custom_order_title)}

    val plusButton = KButton {withText("+")}
    val minusButton = KButton {withText("-")}
    val espressoShotCounterTextView = KTextView{ withId(R.id.espresso_shot_counter) }

    val temperatureCheckbox = KCheckBox{withId(R.id.beverage_temperature)}

    val chocolateCheckbox = KCheckBox{withId(R.id.chocolate)}

    val milkTypeTextView = KTextView{ withId(R.id.milk_type) }
    val lowFatDropDownItem =  KTextView{
        withText("Low fat")}
    val customDropDownItem =  KTextView{
        withText("Custom %")}

    val customFatTextView = KTextView{withId(R.id.custom_fat_percentage_text)}
    val customFatPercentageTextTextView = KTextView{ withId(R.id.custom_fat_percentage_text) }

    val milkСonditionsRadioButtons = KView{ withId(R.id.radio_group) }
    val steamedRadioButton =  KButton{
        withParent { withId(R.id.radio_group) }
        withText("Steamed")}
    val foamedRadioButton =  KButton{
        withParent { withId(R.id.radio_group) }
        withText("Foamed")}
    val whippedRadioButton =  KButton{
        withParent { withId(R.id.radio_group) }
        withText("Whipped")}
    val scaldedRadioButton =  KButton{
        withParent { withId(R.id.radio_group) }
        withText("Scalded")}

    val reviewButton = KButton {withText(R.string.review_order_button)}
}