package com.demo.pagingdemo

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource

class EntityDataSourceFactory() : DataSource.Factory<Int, Entity>() {

    val entityDataSourceLiveData = MutableLiveData<EntityDataSource>()

    override fun create(): DataSource<Int, Entity> {
        val newsDataSource = EntityDataSource()
        entityDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }
}
