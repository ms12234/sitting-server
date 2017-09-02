package com.sitting.server

data class Sensor(var x: Float, var y: Float, var position: Position) {

    constructor() : this(0F, 0F, Position.Back)
}
