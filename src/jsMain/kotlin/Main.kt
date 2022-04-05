import androidx.compose.runtime.*
import elements.HeaderStylesheet
import elements.header
import elements.pronounsDotpage.PronounsPageSection
import kotlinx.browser.window
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import org.w3c.dom.events.Event
import structs.EResponse
import util.StateChangeEvent

@OptIn(ExperimentalComposeWebApi::class)
fun main() {


    renderComposable(rootElementId = "root") {

        val coroutineScope = rememberCoroutineScope()
        var pronounsPageData by mutableStateOf<EResponse?>(null)

        coroutineScope.launch {
            pronounsPageData = getPronounsPageData()
        }
        Style(AppStylesheet)
        Style(HeaderStylesheet)
        Div({
            classes(AppStylesheet.centered)
            style {
                alignItems(AlignItems.Center)
            }

        }) {
            header()
            Div({
                if (State.page == Page.PROJECTS) {
                    style {

                    }
                } else {
                    style {
                        display(DisplayStyle.Unset)
                    }
                }
            }) {
                if (pronounsPageData != null) {
                    println("pronounsPageData not null, rendering")
                    PronounsPageSection(pronounsPageData!!)
                }
            }


        }
    }
}
