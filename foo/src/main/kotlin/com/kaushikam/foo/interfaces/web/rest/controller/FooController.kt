package com.kaushikam.foo.interfaces.web.rest.controller

import com.kaushikam.foo.application.IFooService
import com.kaushikam.foo.domain.model.foo.Foo
import com.kaushikam.foo.domain.model.foo.FooDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/foos")
class FooController(
    private val fooService: IFooService
) {
    @GetMapping("/{id}")
    @CrossOrigin(origins = ["http://localhost:8089"])
    fun findOne(@PathVariable id: Long): FooDto {
        val entity = fooService.findById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        return convertToDto(entity)
    }

    @GetMapping
    fun findAll(): Collection<FooDto> {
        val foos = fooService.findAll()
        val fooDtos = mutableListOf<FooDto>()
        foos.forEach {
            fooDtos.add(convertToDto(it))
        }
        return fooDtos
    }

    protected fun convertToDto(entity: Foo): FooDto {
        return FooDto(entity.id, entity.name)
    }
}