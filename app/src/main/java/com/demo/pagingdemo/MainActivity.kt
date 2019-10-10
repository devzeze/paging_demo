package com.demo.pagingdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val pagedListLiveData: LiveData<PagedList<Entity>>
    private val newsDataSourceFactory: EntityDataSourceFactory

    init {
        newsDataSourceFactory = EntityDataSourceFactory()
        val config = PagedList.Config.Builder()
            .setPageSize(10)
            .setEnablePlaceholders(false)
            .build()
        pagedListLiveData = LivePagedListBuilder<Int, Entity>(newsDataSourceFactory, config).build()
        pagedListLiveData.observe(this, Observer {
            val adapter = EntityAdapter()
            adapter.submitList(it)
            entity_list.adapter = adapter
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        entity_list.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        entity_list.adapter = EntityAdapter()

    }
}
