package nl.testchamber.mailordercoffeeshop.screen

import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.text.KButton
import com.kaspersky.kaspresso.screens.KScreen
import nl.testchamber.mailordercoffeeshop.R
import nl.testchamber.mailordercoffeeshop.order.HeaderFragment

object HeaderScreen: KScreen<HeaderScreen>(){
    override val layoutId:Int? = R.layout.fragment_header
    override val viewClass:Class<*>?= HeaderFragment::class.java

    val customOrderButton = KButton {withId(R.id.use_custom)}
    val menuButton = KButton {withId(R.id.use_menu)}
}