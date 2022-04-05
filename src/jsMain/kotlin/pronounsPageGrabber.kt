import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json
import structs.EResponse
val httpClient = HttpClient()
suspend fun getPronounsPageData(): EResponse {
    println("Getting pronouns page data")
    return httpClient.get<String>(Consts.pronounsPageApiUrl)
        .let { Json.decodeFromString(EResponse.serializer(), it) }
}