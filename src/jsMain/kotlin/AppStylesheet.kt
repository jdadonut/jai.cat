import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.css.*

object AppStylesheet : StyleSheet() {
    init {
        universal style {

        }
        "body" style {
            margin(0.vw)
            padding(0.vw)
            backgroundColor(Theme.current.backgroundColor)
        }
        // all text
        "body, h1, h2, h3, h4, h5, h6, p, ul, ol, li, dl, dt, dd, pre, code, samp" style {
            fontFamily("Trebuchet MS", "Arimo")
            fontSize(1.em)
            color(Theme.current.textColor)
        }
        // buttons
        "button, input[type=button], input[type=submit], input[type=reset]" style {
            backgroundColor(Color.transparent)
            color(Theme.current.textColor)
            border(2.px, LineStyle.Solid, Theme.current.accentColor)
            borderRadius(0.5.em)
            padding(0.5.em)
            fontSize(1.em)
            fontWeight("bold")
            cursor("pointer")
        }

    }
    @OptIn(ExperimentalComposeWebApi::class)
    val centered by style {
        position(Position.Absolute)
        top(50.vh)
        left(50.vw)
        transform {
            translate((-50).percent, (-50).percent)
        }


    }
}