package pro.wsmi.kwsmilib

fun <T> Comparable<T>.limit(upper_limit: Comparable<T>? = null, lower_limit: Comparable<T>? = null) : Comparable<T> = when {
    upper_limit != null && this > (upper_limit as T) -> upper_limit
    lower_limit != null && this < (lower_limit as T) -> lower_limit
    else -> this
}