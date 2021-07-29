package ru.chebertests.mykotlintojavaproject

open class Repository : IRepository {

    private val cat : Cats = Cats("Барсик",4)
    val doggy : Dogs = Dogs("Барбос", 75)
    val doggy2 = doggy.copy("Младший Барбос")

    private val pets : List<Pets> = listOf(
            Pets("Мухтар",4),
            Pets("Васисуалий",2),
            Pets("Борис", 8),
            cat,
            UnoCat.getUnoCat(),
            doggy,
            doggy2
    )

    override fun getData(): List<Pets> {
        return pets
    }
}

interface IRepository {
    fun getData() : List<Pets>
}