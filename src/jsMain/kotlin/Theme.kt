import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.rgb

object Theme {
    var isDark: Boolean = true
    val String.color: CSSColorValue
        get() = this.let { hex ->
            if (hex.startsWith("#")) {
                hex.substring(1).let {
                    val r = it.substring(0, 2)
                    val g = it.substring(2, 4)
                    val b = it.substring(4, 6)
                    return rgb(r.toInt(16), g.toInt(16), b.toInt(16))
                }
            } else {
                hex.let {
                    val r = it.substring(0, 2)
                    val g = it.substring(2, 4)
                    val b = it.substring(4, 6)
                    return rgb(r.toInt(16), g.toInt(16), b.toInt(16))
                }
            }
        }

    abstract class _theme {
        abstract val backgroundColor: CSSColorValue
        abstract val abovegroundColor: CSSColorValue
        abstract val textColor: CSSColorValue
        abstract val accentColor: CSSColorValue
        abstract val primaryColor: CSSColorValue
    }

//    object Dark : _theme() {
//        override val backgroundColor = rgb(1, 2, 3)
//
//    }
//    object Light : _theme() {
//        override val backgroundColor = rgb(0x40, 0x50, 0x60)
//
//    }
    object Palettes {
        object Catppucin {
            val rosewater =   "#F5E0DC".color
            val flamingo =    "#F2CDCD".color
            val mauve =       "#DDB6F2".color
            val pink =        "#F5C2E7".color
            val maroon =      "#E8A2AF".color
            val red =         "#F28FAD".color
            val peach =       "#F8BD96".color
            val yellow =      "#FAE3B0".color
            val green =       "#ABE9B3".color
            val teal =        "#B5E8E0".color
            val blue =        "#96CDFB".color
            val sky =         "#89DCEB".color
            val lavender =    "#C9CBFF".color

            val black0 =      "#161320".color
            val black1 =      "#1A1826".color
            val black2 =      "#1E1E2E".color
            val black3 =      "#302D41".color
            val black4 =      "#575268".color
            val gray0 =       "#6E6C7E".color
            val gray1 =       "#988BA2".color
            val gray2 =       "#C3BAC6".color
            val white =       "#D9E0EE".color
        }
    }
    object CatppucinDark : _theme() {
        override val backgroundColor = Palettes.Catppucin.black0
        override val abovegroundColor = Palettes.Catppucin.black1
        override val textColor = Palettes.Catppucin.white
        override val accentColor = Palettes.Catppucin.rosewater
        override val primaryColor = Palettes.Catppucin.lavender
    }
    object CatppucinLight : _theme() {
        override val backgroundColor = Palettes.Catppucin.white
        override val abovegroundColor = Palettes.Catppucin.gray0
        override val textColor = Palettes.Catppucin.black0
        override val accentColor = Palettes.Catppucin.peach
        override val primaryColor = Palettes.Catppucin.yellow
    }
    fun get(): _theme {
        return if (isDark) {
            CatppucinDark
        } else {
            CatppucinLight
        }
    }
    val current: _theme
        get() = get()

}