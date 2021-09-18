package ru.sber.oop

open class Room(val name: String, val size: Int) {
    protected open val dangerLevel = 5

    constructor(name: String) : this(name, 100)

    fun description() = "Room: $name"

    open fun load() = "Nothing much to see here..."

}

class TownSquare() : Room("Town Square", 1000) {
    final override fun load() = "Loading..."

    override val dangerLevel = super.dangerLevel - 3
}

