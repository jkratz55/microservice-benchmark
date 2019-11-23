package io.jkratz.employee

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutorService
import kotlin.collections.ArrayList

@Service
class EmployeeService (@Autowired @Qualifier("outboundHttpPool") val executorService: ExecutorService) {

    fun getEmployee(id: String): Employee {

        loadEmployeeFromHR(id)
        val futures = arrayOfNulls<CompletableFuture<Void>>(2)
        futures[0] = CompletableFuture.runAsync({getVacationDetails(id)}, executorService::execute)
        futures[1] = CompletableFuture.runAsync({ getInsuranceDetails(id) }, executorService::execute)

        CompletableFuture.supplyAsync({getInsuranceDetails(employeeId = id)}, executorService::execute)

        CompletableFuture.allOf(*futures).join()
        return Employee()
    }

    private fun getInsuranceDetails(employeeId: String): InsuranceResponse {

        // Simulates a 500ms response from upstream service
        Thread.sleep(500)
        val plans = ArrayList<Plan>()
        plans.add(Plan(type = PlanType.DENTAL, coPay = BigDecimal(40.00), dependents = 1, provider = "AFLACK"))
        plans.add(Plan(type = PlanType.MEDICAL, coPay = BigDecimal(40.00), dependents = 1, provider = "AFLACK"))
        return InsuranceResponse(employeeId = UUID.randomUUID(), plans = plans)
    }

    private fun getVacationDetails(employeeId: String) {
        // Simulates a 300ms response from upstream service
        Thread.sleep(300)
    }

    private fun loadEmployeeFromHR(id: String) {
        // Simulates a 500ms response from upstream service
        Thread.sleep(500)
    }
}
