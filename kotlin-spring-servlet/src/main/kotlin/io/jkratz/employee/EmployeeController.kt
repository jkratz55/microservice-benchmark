package io.jkratz.employee

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class EmployeeController (@Autowired val employeeService: EmployeeService) {

    @GetMapping(path = ["/{id}"])
    fun getEmployee(@PathVariable("id") id: String): ResponseEntity<Any> {
        employeeService.getEmployee(id)
        return ResponseEntity.ok().build<Any>()
    }
}