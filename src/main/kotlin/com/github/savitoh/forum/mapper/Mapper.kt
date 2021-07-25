package com.github.savitoh.forum.mapper

interface Mapper<T, R> {

    fun map(t: T): R

}