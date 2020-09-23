package nl.testchamber.mailordercoffeeshop.screen

import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.edit.KTextInputLayout
import com.agoda.kakao.tabs.KTabLayout
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.kaspersky.kaspresso.screens.KScreen
import nl.testchamber.mailordercoffeeshop.R

object ReviewOrderScreen: KScreen<ReviewOrderScreen>(){
    override val layoutId:Int? = R.layout.activity_order_overview
    override val viewClass:Class<*>?= nl.testchamber.mailordercoffeeshop.orderoverview.OrderOverviewActivity::class.java


    val detailTitle = KTextView{withId(R.id.beverage_detail_title)}
    val detailVolume = KTextView{withId(R.id.beverage_detail_volume_text)}
    val detailIngredients = KButton {withId(R.id.beverage_detail_ingredients)}
    val nameTextBox = KEditText {withId(R.id.name_text_box)}
    val nameTextInputLayout = KTextInputLayout{withId(R.id.name_input_layout)}
    val emailTextBox = KEditText {withId(R.id.email_text_box)}
    val customOrderTextBox = KEditText {withId(R.id.custom_order_name_box)}
    val customOrderInputLayout = KTextInputLayout{withId(R.id.custom_order_name_input_layout)}
    val mailOrderButton = KButton {withId(R.id.mail_order_button)}
}
