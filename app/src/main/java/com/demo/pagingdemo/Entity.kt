package com.demo.pagingdemo

class Entity(_name: String, _description: String) {
    lateinit var name: String;
    lateinit var description: String;

    init {
        this.name = _name
        this.description = _description
    }
}
