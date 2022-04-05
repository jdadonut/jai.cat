package elements.pronounsDotpage

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLImageElement

@Composable
fun CustomFlag(id: String, name: String) = Flag("flags/$id-flag.png", name)

@Composable
fun Flag(uri: String, name: String) {
    Div({
        style {
            display(DisplayStyle.Grid)
            gridTemplateColumns("auto 1fr")
            paddingBottom(8.px)
        }
    }) {
        Img(src = uri, alt = name) {
            addEventListener("error") {
                (it.target as HTMLImageElement).src = "flags/unknown.png"
            }
            style {
                height(50.px)
                width(auto)
                borderRadius( 5.px)
            }
        }
        Span({
            style {
                fontSize(1.5.em)
                paddingLeft(10.px)
                alignSelf(AlignSelf.Center)
                left(0.px)
            }
        }) {
            Text(name)
        }

    }
}