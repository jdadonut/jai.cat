import androidx.compose.runtime.*

enum class Page {
    NONE,
    ABOUT,
    PROJECTS,
}
object State {
    var page by mutableStateOf(Page.NONE)
}