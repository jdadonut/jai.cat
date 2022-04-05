package elements.pronounsDotpage

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun Pronoun(it: String, v: Int) {
    when (v) {
        1 -> {
            pWith(it, Consts.Icons.heart, "heart")
        }
        0 -> {
            pWith(it, Consts.Icons.thumbsUp, "thumbs-up")
        }
        3 -> {
            pWith(it, Consts.Icons.friends, "friends")
        }
    }
}
@OptIn(ExperimentalComposeWebApi::class)
@Composable
fun pWith(it: String, img: String, alt: String) {
    Div({
        style {
            display(DisplayStyle.Grid)
            gridTemplateColumns("auto 1fr")
            paddingTop(8.px)
        }
    }){
        Img(img, alt) {
            style {
                width(2.em)
                if (Theme.isDark) {
                    filter {
                        invert(100.percent)
                    }
                }
                alignSelf(AlignSelf.Center)
            }
        }
        P({
            style {
                padding(0.px)
                margin(0.px)
                alignSelf(AlignSelf.Center)
                paddingLeft(1.em)

            }
        }) {
            Text(it)
        }
    }
}