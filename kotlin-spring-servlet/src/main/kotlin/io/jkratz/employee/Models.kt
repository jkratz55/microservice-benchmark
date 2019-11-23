package io.jkratz.employee

import java.math.BigDecimal
import java.util.*

data class InsuranceResponse(val employeeId: UUID,
                             val plans: List<Plan>)

data class Plan(val type: PlanType,
                val provider: String,
                val dependents: Int,
                val coPay: BigDecimal)

enum class PlanType(val code: Int) {
    DENTAL(33001),
    MEDICAL(33400),
    VISION(44112)
}