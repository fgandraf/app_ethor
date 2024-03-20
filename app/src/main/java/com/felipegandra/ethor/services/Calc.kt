package com.felipegandra.ethor.services

import kotlin.math.abs

fun calculate(gasoline: Float, ethanol: Float) : Float{
    return ethanol / gasoline
}

fun diference(coef: Float):String{
    return "${String.format("%.0f", abs(coef * (-100) + 100))} %"
}