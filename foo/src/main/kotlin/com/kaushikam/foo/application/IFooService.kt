package com.kaushikam.foo.application

import com.kaushikam.foo.domain.model.foo.Foo

interface IFooService {
    fun findById(id: Long): Foo?
    fun findAll(): Iterable<Foo>
    fun save(foo: Foo): Foo
}