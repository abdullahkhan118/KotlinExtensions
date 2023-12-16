package com.horux.extensions

inline fun <reified T> Boolean.doThen(lambda: () -> T): T = lambda()

inline fun <reified T> Boolean.doElse(lambda: () -> T): T = lambda()