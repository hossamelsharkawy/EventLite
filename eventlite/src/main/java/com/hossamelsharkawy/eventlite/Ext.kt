package com.hossamelsharkawy.eventlite

import kotlinx.coroutines.*

/**
 * Created by Hossam Elsharkawy
0201099197556
on 01/07/19.  time :09:24

 */

@Synchronized
fun <A> ArrayList<A>.forEachParallelAfterFirst(block: suspend (A) -> Unit) {
    if (this.size > 0) {
        launchOnUI {block.invoke(get(0))}
        if (this.size > 1) {
            for (i in 1 until this.size) {
                launchAsync { block.invoke(get(i)) }
            }
        }
    }
}

@Synchronized
fun <A> Collection<A>.forEachParallel(block: suspend (A) -> Unit) = forEach {
    launchAsync { block.invoke(it) }
}


fun launchOnUI(block: suspend CoroutineScope.() -> Unit) = GlobalScope.launch(Dispatchers.Main) { block() }

fun launchAsync(block: suspend CoroutineScope.() -> Unit): Job = launchOnUI { asyncAwait { block.invoke(this) } }

suspend fun <T> asyncAwait(block: suspend CoroutineScope.() -> T): T = async(block).await()

suspend fun <T> async(block: suspend CoroutineScope.() -> T): Deferred<T> =
    GlobalScope.async(Dispatchers.Main) { block() }