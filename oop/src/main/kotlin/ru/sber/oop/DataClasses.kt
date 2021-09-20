package ru.sber.oop

data class User(val name: String, val age: Long) {
    lateinit var city: String

    @Override
    override fun equals(other: Any?): Boolean {
        if (other is User)
            return this.name == other.name
                    && this.age == other.age
                    && this.city == other.city
        return false
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + age.hashCode()
        result = 31 * result + city.hashCode()
        return result
    }
}

fun main() {
    val user1 = User("Alex", 13)
    val user2 = user1.copy(name = "User2 Name")

    user1.city = "Omsk"

    val user3 = user1.copy()
    user3.city = "Tomsk"

    assert(user1 != user3)
}