package pro.wsmi.kwsmilib

fun Comparable<Number>.limit(upper_limit: Number? = null, lower_limit: Number? = null) : Number = when {
    upper_limit != null && this > upper_limit -> upper_limit
    lower_limit != null && this < lower_limit -> lower_limit
    else -> this as Number
}