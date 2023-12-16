package com.horux.extensions

fun <T : Any> String?.ifNotNullOrEmpty(perform: (String) -> T): Boolean = if (!this.isNullOrEmpty()) {
    perform(this)
    true
} else {
    false
}

fun String.inRange(min: Int, max: Int, minInclusive: Boolean = true, maxInclusive: Boolean = true) = when {
    minInclusive && maxInclusive -> length in min..max
    minInclusive -> length in min until max
    maxInclusive -> length in min + 1..max
    else -> length in min + 1 until max
}

fun String.notInRange(min: Int, max: Int, minInclusive: Boolean = true, maxInclusive: Boolean = true) =
    !inRange(min, max, minInclusive, maxInclusive)

fun String?.upperCaseCount() = this?.count { Character.isUpperCase(it) } ?: 0
fun String?.lowercaseCaseCount() = this?.count { Character.isLowerCase(it) } ?: 0
fun String?.digitsCount() = this?.count { Character.isDigit(it) } ?: 0
fun String?.alphabetsCount() = upperCaseCount() + lowercaseCaseCount()