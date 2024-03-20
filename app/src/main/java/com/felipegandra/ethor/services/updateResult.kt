package com.felipegandra.ethor.services

import com.felipegandra.ethor.R

fun updateResult (
    valueGasoline: Float,
    valueEthanol: Float
) : Triple<Float, String, Int>
{
    val coefficient = calculate(valueGasoline, valueEthanol)
    val background : Int
    val result : String

    if (coefficient > 0.70f) {
        result = "GASOLINA"
        background = R.drawable.gasoline
    } else {
        background = R.drawable.etanol
        result = "ETANOL"
    }
    return Triple(coefficient, result, background)
}