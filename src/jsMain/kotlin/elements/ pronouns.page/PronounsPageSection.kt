package elements.pronounsDotpage

import Consts
import androidx.compose.runtime.Composable
import getPronounsPageData
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import structs.EResponse
import util.iterateAveraged

@Composable
fun PronounsPageSection(data: EResponse) {
    val prof = data.profiles["en"]!!

        Div({
            style {
                display(DisplayStyle.Grid)
                gridTemplateColumns("auto auto auto auto auto")
                alignItems(AlignItems.Center)
                backgroundColor(Theme.current.abovegroundColor)
                padding(30.px)
                borderRadius(10.px)
            }
        }) {
            // for now, only flags
            Div {
                for (flagName in prof.flags) {
                    Flag(Consts.pronounsPageFlagPoint.replace("{}", flagName), flagName)
                }
                for ((k, v) in prof.customFlags) {
                    CustomFlag(k, v)
                }
                H1({
                    style {
                        fontSize(30.px)
                    }
                }) { Text("call me...")}
                ratedSection(prof.names)
            }
            ratedSection(prof.pronouns)
            for (obj in iterateAveraged(3, prof.words.flatMap { map ->
                map.entries.filter { listOf(0,1,3).contains(it.value) }.map { it.key to it.value }
            })){
                Div {
                    for (z in iterateAveraged(2, obj.toList())) {
                        ratedSection(z)
                    }
                }

            }
        }
}
@Composable
fun ratedSection(list: Map<String, Int>) {
    Div({
        style {
            paddingLeft(10.px)
        }
    }) {
        for ((k,v) in list) {
            if (k.startsWith(":")){
                k.substring(1).let {
                    Pronoun("$it/${it}s", v)
                }
            } else {
                Pronoun(k, v)
            }
        }
    }
}
