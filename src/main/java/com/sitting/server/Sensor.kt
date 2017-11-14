package com.sitting.server

data class Sensor(var x: Float, var y: Float, var position: Position,
                  var value: Double) {

    constructor() : this(0F, 0F, Position.Back, 1.0)
}
