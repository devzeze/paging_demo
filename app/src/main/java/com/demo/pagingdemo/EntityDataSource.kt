package com.demo.pagingdemo

import android.util.Log
import androidx.paging.PageKeyedDataSource
import java.util.*

private const val TAG = "EntityDataSource"

class EntityDataSource() : PageKeyedDataSource<Int, Entity>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Entity>
    ) {
        Log.v(TAG, "EntityDataSource loadInitial")
        val listEntities = LinkedList<Entity>();
        for (x in 1..20) {
            val entity = Entity("Name " + x, "Description " + x)
            listEntities.add(entity)
        }
        callback.onResult(listEntities, null, 1)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Entity>) {
        Log.v(TAG, "EntityDataSource loadAfter - " + params.key)
        val listEntities = LinkedList<Entity>();
        val offset = params.key * 20
        for (x in 1..20) {
            val entity = Entity("Name " + (x + offset), "Description " + (x + offset))
            listEntities.add(entity)
        }
        callback.onResult(listEntities, params.key + 1)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Entity>) {

    }

}
