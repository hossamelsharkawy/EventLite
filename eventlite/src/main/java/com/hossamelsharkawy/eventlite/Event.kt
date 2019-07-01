package com.hossamelsharkawy.eventlite

/**
 * Created by Hossam Elsharkawy
0201099197556
on 01/07/19.  time :09:24

 */
open class Event<Model> {

    private val arrayList = arrayListOf<(Model) -> Unit>()

     @Synchronized
     fun emit(model: Model) = arrayList.forEachParallelAfterFirst { it.invoke(model) }

     @Synchronized
     fun sub(action: (Model) -> Unit) = arrayList.add(action)

     @Synchronized
     fun unSub(action: (Model) -> Unit) = arrayList.remove(action)

}