package ru.sber.oop

fun Monster.getSalutation() = "I'll kill you"

open class Room(val name: String, val size: Int) {
    protected open val dangerLevel = 5
    private val monster: Monster = Goblin("Goblusha", "Cute goblin", "Weak attack", 100)

    constructor(name: String) : this(name, 100)

    fun description() = "Room: $name"

    open fun load() = "Nothing much to see here... Except for the Monster:\"${monster.getSalutation()}\"!"

}

class TownSquare() : Room("Town Square", 1000) {
    final override fun load() = "Loading $name"

    override val dangerLevel = super.dangerLevel - 3
}

