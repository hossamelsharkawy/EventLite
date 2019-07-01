package com.hossamelsharkawy.eventlite

/**
 * Created by Hossam Elsharkawy
0201099197556
on 01/07/19.  time :09:26

 */
class EventN {
    private val arrayList = arrayListOf<() -> Unit>()

    fun emit() = arrayList.forEachParallel { it() }

    @Synchronized
    fun sub(action: () -> Unit) = arrayList.add(action)

    @Synchronized
    fun unSub(action: () -> Unit) = arrayList.remove(action)
}
