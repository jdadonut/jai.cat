package structs

import kotlinx.serialization.*
import kotlinx.serialization.json.*
@Serializable
data class EResponse (
    val id: String,
    val username: String,
    val avatarSource: String,
    val bannedReason: JsonObject? = null,
    val bannedTerms: JsonArray,
    val team: Long,
    val emailHash: String,
    val avatar: String,
    val profiles: Map<String, LangEntry>
)
@Serializable
data class LangEntry (
    val names: Map<String, Int>,
    val pronouns: Map<String, Int>,
    val description: String,
    val age: Int,
    val links: JsonArray,
    val verifiedLinks: Map<String, String>,
    val flags: List<String>,
    val customFlags: Map<String, String>, // need to figure out how to get flag from here (map of flag id to name)
    val words: List<Map<String, Int>>,
    val birthday: String? = null,
    val teamName: String? = null,
    val footerName: String,
    val footerAreas: JsonArray,
    val credentials: JsonArray?,
    val credentialsLevel: JsonObject? = null,
    val credentialsName: JsonObject? = null,
    val card: JsonObject? = null,
    val cardDark: JsonObject? = null
)
