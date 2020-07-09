package com.kaushikam.foo.domain.model.foo

import org.springframework.data.repository.PagingAndSortingRepository

interface IFooRepository: PagingAndSortingRepository<Foo, Long>