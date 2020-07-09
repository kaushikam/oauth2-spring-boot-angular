package com.kaushikam.foo.application.impl

import com.kaushikam.foo.application.IFooService
import com.kaushikam.foo.domain.model.foo.Foo
import com.kaushikam.foo.domain.model.foo.IFooRepository
import org.springframework.stereotype.Service

@Service
class FooServiceImpl(
    private val fooRepository: IFooRepository
): IFooService {
    override fun findById(id: Long): Foo? {
        return fooRepository.findById(id).orElse(null)
    }

    override fun findAll(): Iterable<Foo> {
        return fooRepository.findAll()
    }

    override fun save(foo: Foo): Foo {
        return fooRepository.save(foo)
    }
}