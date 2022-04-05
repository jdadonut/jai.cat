package util

inline fun <reified A,B> iterateAveraged(count: Int, allItems: List<Pair<A,B>>): List<Map<A,B>> {
    /*
    sorts {list} into {count} groups of equal size
    */
    val groups = allItems.filter { it.first != null }.chunked(allItems.filter { it.first != null }.count() / count)
    println("val groups = allItems.chunked(${allItems.filter { it.first != null }.count()} / $count)")
    return groups.map { it.toMap() }
}