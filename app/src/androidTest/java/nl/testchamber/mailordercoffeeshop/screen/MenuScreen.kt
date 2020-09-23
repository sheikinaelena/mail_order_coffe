package nl.testchamber.mailordercoffeeshop.screen

import android.view.View
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.kaspersky.kaspresso.screens.KScreen
import nl.testchamber.mailordercoffeeshop.R
import nl.testchamber.mailordercoffeeshop.order.HeaderFragment
import nl.testchamber.mailordercoffeeshop.order.beveragesmenu.MenuFragment
import org.hamcrest.Matcher

object MenuScreen: KScreen<MenuScreen>(){
    override val layoutId:Int? = R.layout.fragment_beverage_list
    override val viewClass:Class<*>?= MenuFragment::class.java

    val menuRecyclerView = KRecyclerView({ withId(R.id.beverage_recycler_view) }, {
        itemType(::MenuItem)
    })

    class MenuItem(parent: Matcher<View>) : KRecyclerItem<MenuItem>(parent) {
        val itemVolumeTextView = KTextView(parent) { withId(R.id.item_volume) }
        val itemNameTextView = KTextView(parent) { withId(R.id.item_name) }
    }
}