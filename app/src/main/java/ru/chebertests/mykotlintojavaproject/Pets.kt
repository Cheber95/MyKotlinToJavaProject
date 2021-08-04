package ru.chebertests.mykotlintojavaproject

open class Pets(open val name: String, open val age: Int)

class Cats(name: String, age: Int) : Pets(name, age)

data class Dogs(override val name: String, override var age: Int) : Pets(name,age)

object UnoCat {
    private val unoCat : Cats = Cats("кот-синглтон", 100)
    fun getUnoCat() : Cats {
        return unoCat
    }
}

