package elements

import Page
import State
import androidx.compose.runtime.Composable
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.*
import util.StateChangeEvent


@Composable
fun header() {
    Div({
        classes(HeaderStylesheet.mainDivGrid)
    }) {

        Img("pfp.png", "profile picture") {
            classes(HeaderStylesheet.profilePicture)
        }
        Div({
            classes(HeaderStylesheet.textGrid)
        }) {
            H1({
                style {
                    fontSize(30.px)
                }
            }) { Text("hi, im jai") }
            H2({
                style {
                    fontSize(15.px)
                }
            }) { Text("developer, leftist, catgirl.") }
            Div({
                classes(HeaderStylesheet.buttonsGrid)
            }) {
                Button({
                    if (State.page == Page.ABOUT) {
                        style {
                            backgroundColor(Theme.current.accentColor)
                            color(Theme.current.backgroundColor)
                        }
                    }
                    onClick {
                        State.page = Page.ABOUT
                    }
                }) {
                    Text("about")
                }
                Button({
                    if (State.page == Page.PROJECTS) {
                        style {
                            backgroundColor(Theme.current.accentColor)
                            color(Theme.current.backgroundColor)
                        }
                    }
                    onClick {
                        State.page = Page.PROJECTS
                    }

                }) {
                    Text("projects")
                }

            }
        }
    }
}
object HeaderStylesheet : StyleSheet() {

    val profilePicture by style {
        width(100.px)
        height(100.px)
        borderRadius(50.px)
    }
    val mainDivGrid by style {
        display(DisplayStyle.Grid)
        gridTemplateColumns("1fr 5fr")
        gap(10.px)
        marginBottom(10.px)
        width(auto)



    }
    val textGrid by style {
        display(DisplayStyle.Grid)
        gridTemplateColumns("1fr")
        gridTemplateRows("1fr 0.8fr 1.2fr")
        width(auto)

        "> *" style {
            margin(0.px)
            width(auto)
            padding(0.px)
        }
    }
    val buttonsGrid by style {
        display(DisplayStyle.Grid)
        gridTemplateColumns("1fr 1fr 1fr 1fr 1fr")
        gap(10.px)
    }

}